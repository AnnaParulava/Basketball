package com.example.basketball.pojo

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "team")
data class Team(
    @PrimaryKey
    val team_key: String,
    val team_name: String,
    val team_logo: String
)