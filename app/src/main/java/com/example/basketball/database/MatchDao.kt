package com.example.basketball.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.basketball.pojo.Match

@Dao
interface MatchDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMatches(matches:  List<Match>)

    @Query("SELECT * FROM `match`")
    suspend fun getMatchList(): List<Match>

    @Query("SELECT away_team_key FROM `match` WHERE event_away_team == :away_team LIMIT 1")
    suspend fun getMatchKey(away_team: String?): Match? = null
}