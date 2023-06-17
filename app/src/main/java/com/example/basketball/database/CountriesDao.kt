package com.example.basketball.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.basketball.pojo.Country
import com.example.basketball.pojo.CountryApiResponse

@Dao
interface CountriesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCountry(countries: List<Country>)

    @Query("SELECT * FROM country")
    suspend fun getCountries(): List<Country>
}
