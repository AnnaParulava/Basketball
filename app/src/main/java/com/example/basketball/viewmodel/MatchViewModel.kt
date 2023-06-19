package com.example.basketball.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.basketball.api.ApiFactory.apiService
import com.example.basketball.database.AppDatabase
import com.example.basketball.pojo.Match
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MatchViewModel(application: Application) : AndroidViewModel(application) {

    private val db = AppDatabase.getInstance(application)

    private val _matches = MutableLiveData<List<Match>>()
    val matches: LiveData<List<Match>> = _matches

    init {
        loadMatches()
    }

    private fun updateData() {
        viewModelScope.launch(Dispatchers.IO) {
            val matchDao = db.matchesDao()

            while (true) {
                val matches = apiService.getMatches().result
                matchDao.insertMatches(matches)
                delay(20000)
            }
        }
    }


    private fun loadMatches() {
        viewModelScope.launch(Dispatchers.IO) {
            val matchDao = db.matchesDao()
            val savedMatches = matchDao.getMatchList()

            updateData()

            withContext(Dispatchers.Main) {
                _matches.value = savedMatches
                while (true) {
                    _matches.value = matchDao.getMatchList()
                    delay(20000)
                }
            }
        }
    }


}