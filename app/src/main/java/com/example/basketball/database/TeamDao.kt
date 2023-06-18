package com.example.basketball.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.basketball.pojo.Team

@Dao
interface TeamDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTeam(team: List<Team>)

    @Query("SELECT * FROM team")
    suspend fun getTeam(): List<Team>

    @Query("SELECT team.team_logo FROM team")
    suspend fun getTeamLogo(): Team? = null
}

