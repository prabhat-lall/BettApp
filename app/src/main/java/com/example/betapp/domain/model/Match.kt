package com.example.betapp.domain.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Match(
    val activeStatus: String,
    val id: Int,
    val matchName: String,
    val numberOfBetsAvailable: Int,
    val teamFirst: String,
    val teamSecond: String
) : Serializable