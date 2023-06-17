package com.example.basketball.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SplashViewModel : ViewModel() {
    fun loadData() {
        viewModelScope.launch(Dispatchers.IO) {
//            val apiService = ApiClient.apiService
//
//            val matches = apiService.getMatches()
//            val players = apiService.getPlayers()
//            val leagues = apiService.getLeagues()
//
//            val matchDao = AppDatabase.getInstance().matchDao()
//            val playerDao = AppDatabase.getInstance().playerDao()
//            val leagueDao = AppDatabase.getInstance().leagueDao()
//
//            matchDao.insertMatches(matches)
//            playerDao.insertPlayers(players)
//            leagueDao.insertLeagues(leagues)
        }
    }
}