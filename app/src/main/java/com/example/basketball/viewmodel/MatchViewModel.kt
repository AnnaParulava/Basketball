package com.example.basketball.viewmodel

import android.app.Application
import android.os.Parcel
import android.os.Parcelable
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.basketball.database.AppDatabase
import com.example.basketball.pojo.Match
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import androidx.lifecycle.viewModelScope
import com.example.basketball.pojo.Team
import kotlinx.coroutines.launch

class MatchViewModel (application: Application) : AndroidViewModel(application)  {

    private val db = AppDatabase.getInstance(application)

    private val _matches = MutableLiveData<List<Match>>()
    private val _team = MutableLiveData<List<Team>>()
    val matches: LiveData<List<Match>> = _matches
    val team: LiveData<List<Team>> = _team

    init {
        loadMatches()
    }

    private fun loadMatches() {
        viewModelScope.launch(Dispatchers.IO) {
            val matchDao = db.matchesDao()
            val savedMatches = matchDao.getMatchList()

            val teamDao = db.teamDao()
            val savedTeam = teamDao.getTeam()

            withContext(Dispatchers.Main) {
                _matches.value = savedMatches
                _team.value = savedTeam
            }
        }
    }


}