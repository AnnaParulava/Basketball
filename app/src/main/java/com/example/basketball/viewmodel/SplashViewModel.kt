package com.example.basketball.viewmodel

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.basketball.api.ApiFactory
import com.example.basketball.database.AppDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SplashViewModel(application: Application) : AndroidViewModel(application) {

    private val db = AppDatabase.getInstance(application)
    private val connectivityManager =
        application.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    private fun isNetworkAvailable(): Boolean {
        val networkCapabilities = connectivityManager.activeNetwork?.let {
            connectivityManager.getNetworkCapabilities(it)
        }
        return networkCapabilities != null &&
                networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
    }

    fun loadData() {
        viewModelScope.launch(Dispatchers.IO) {
            if (isNetworkAvailable()) {
                val apiService = ApiFactory.apiService
                val matches = apiService.getMatches().result
                val matchDao = db.matchesDao()
                matchDao.insertMatches(matches)
            } else {
                throw RuntimeException("Connection failed")
            }
        }
    }
}