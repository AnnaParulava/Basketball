package com.example.basketball.pojo

import androidx.room.Entity

@Entity(tableName = "country")
data class Country(
    val country_key: String,
    val country_name: String
)
