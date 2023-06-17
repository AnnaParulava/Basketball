package com.example.basketball.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.basketball.pojo.Country
import com.example.basketball.pojo.League
import com.example.basketball.pojo.Match

@Database(entities = [Match::class, Country::class, League::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {

    companion object{
        private var db: AppDatabase? = null
        private const val DB_NAME = "main.db"
        private val LOCK = Any()

        fun getInstance(context: Context): AppDatabase{
            synchronized(LOCK){
                db?.let { return it }
                val instance =
                    Room.databaseBuilder(
                        context,
                        AppDatabase::class.java,
                        DB_NAME
                    ).build()
                db = instance
                return instance
            }
        }
    }

    abstract fun countriesDao(): CountriesDao
}