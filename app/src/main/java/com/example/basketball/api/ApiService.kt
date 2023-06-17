package com.example.basketball.api

import com.example.basketball.pojo.CountryApiResponse
import com.example.basketball.pojo.EventApiResponseResult
import com.example.basketball.pojo.League
import com.example.basketball.pojo.Match
import com.example.basketball.pojo.MatchApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    companion object{
        private const val API_KEY = "14dd14e524d4520208e028b139b44c80718e431fe6dd0c02d4b59ba5bea610f3"
        private const val LIVESCORE = "Livescore"
    }

    @GET("?met=Livescore")
    suspend fun getMatches(
        @Query(API_KEY)  APIkey: String = ""
    ): MatchApiResponse

    @GET("?met=H2H&APIkey=14dd14e524d4520208e028b139b44c80718e431fe6dd0c02d4b59ba5bea610f3&firstTeamId=2616&secondTeamId=2617")
    suspend fun getH2H(
       // @Query(API_KEY)  APIkey: String = ""
    ): EventApiResponseResult

   @GET("?met=Countries&APIkey=14dd14e524d4520208e028b139b44c80718e431fe6dd0c02d4b59ba5bea610f3")
   suspend fun getCountries() : CountryApiResponse

    @GET("leagues")
    suspend fun getLeagues(): List<League>


}