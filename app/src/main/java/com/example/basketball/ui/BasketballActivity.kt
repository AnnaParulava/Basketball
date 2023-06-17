package com.example.basketball.ui

import android.os.Bundle
import android.text.TextUtils.replace
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.basketball.R
import com.example.basketball.api.ApiFactory.apiService
import kotlinx.coroutines.launch


class BasketballActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.basketball_activity_main)


        lifecycleScope.launch {

            val responseCategory = apiService.getCountries()
            Log.d("AAA", "Category: ${responseCategory}")
        }
    }

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.basketball_activity_main)
//
//        navigateToSplashFragment()
//    }
//
//    private fun navigateToSplashFragment() {
//        val splashFragment = SplashFragment()
//        navigateToFragment(splashFragment)
//    }
//
//    private fun navigateToFragment(fragment: Fragment) {
//        val transaction = supportFragmentManager.beginTransaction()
//        with(transaction) {
//            replace(R.id.container, fragment)
//            addToBackStack(null)
//            commit()
//        }
//    }

}