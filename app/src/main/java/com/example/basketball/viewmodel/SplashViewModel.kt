package com.example.basketball.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.basketball.api.ApiFactory
import com.example.basketball.database.AppDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SplashViewModel(application: Application) : AndroidViewModel(application) {

    private val db = AppDatabase.getInstance(application)

     fun loadData() {
        viewModelScope.launch(Dispatchers.IO) {

            val apiService = ApiFactory.apiService

            val matches = apiService.getMatches().result
            val team = apiService.getTeam().result

            val matchDao = db.matchesDao()
            val teamDao = db.teamDao()

            matchDao.insertMatches(matches)
            teamDao.insertTeam(team)
        }
    }
}