package com.example.basketball

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.example.basketball.api.ApiFactory.apiService
import kotlinx.coroutines.launch

class BasketballActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        lifecycleScope.launch {

            val responseCategory = apiService.getCountries()
            Log.d("AAA", "Category: ${responseCategory}")
        }
    }
}