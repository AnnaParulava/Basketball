package com.example.basketball.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class MatchApiResponse(
    val success: Int,
    val result: List<Match>
)