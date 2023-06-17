package com.example.basketball.pojo

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "country")
data class Country(
    @PrimaryKey
    val country_key: String,
    val country_name: String
)
