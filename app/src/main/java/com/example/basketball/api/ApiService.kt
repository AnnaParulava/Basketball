package com.example.basketball.api

import com.example.basketball.pojo.CountryApiResponse
import com.example.basketball.pojo.EventApiResponseResult
import com.example.basketball.pojo.League
import com.example.basketball.pojo.Match
import com.example.basketball.pojo.MatchApiResponse
import com.example.basketball.pojo.Team
import com.example.basketball.pojo.TeamApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    companion object{

        private const val QUERY_API_KEY = "APIkey"
        private const val QUERY_COUNTRIES = "Countries"
        private const val QUERY_LIVESCORE = "Livescore"
        private const val QUERY_TEAM = "Teams"
        private const val QUERY_H2H = "H2H"
        private const val QUERY_TEAM_ID = "teamId"

        private const val API_KEY = "14dd14e524d4520208e028b139b44c80718e431fe6dd0c02d4b59ba5bea610f3"
    }

    @GET("?met=$QUERY_LIVESCORE")
    suspend fun getMatches(
        @Query(QUERY_API_KEY)  APIkey: String = API_KEY
    ): MatchApiResponse

    @GET("?met=$QUERY_H2H")
    suspend fun getH2H(
        @Query(QUERY_API_KEY)  APIkey: String = API_KEY
    ): EventApiResponseResult

   @GET("?met=$QUERY_COUNTRIES")
   suspend fun getCountries(
       @Query(QUERY_API_KEY)  APIkey: String = API_KEY
   ) : CountryApiResponse

    @GET("?met=$QUERY_TEAM")
    suspend fun getTeam(
        @Query(QUERY_API_KEY)  APIkey: String = API_KEY,
        @Query(QUERY_TEAM_ID)  teamId: String? = null
    ): TeamApiResponse


}