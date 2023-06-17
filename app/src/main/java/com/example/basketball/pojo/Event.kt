package com.example.basketball.pojo

data class Event(
    val event_key: String,
    val event_date: String,
    val event_time: String,
    val event_home_team: String,
    val home_team_key: String,
    val event_away_team: String,
    val away_team_key: String,
    val event_final_result: String,
    val event_status: String,
    val country_name: String,
    val league_name: String,
    val league_key: String,
    val league_round: String,
    val league_season: String,
    val event_live: String
)
