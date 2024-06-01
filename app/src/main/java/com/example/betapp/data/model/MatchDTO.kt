package com.example.betapp.data.model

import com.example.betapp.domain.model.Match
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class MatchDTO(
    @SerializedName("active_status")
    val activeStatus: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("match_name")
    val matchName: String,
    @SerializedName("number_of_bets_available")
    val numberOfBetsAvailable: Int,
    @SerializedName("score_team1")
    val scoreTeam1: Int,
    @SerializedName("score_team2")
    val scoreTeam2: Int,
    @SerializedName("team_first")
    val teamFirst: String,
    @SerializedName("team_second")
    val teamSecond: String
) : Serializable

fun MatchDTO.toDomainMatch() : Match {
    return Match(
        id = id,
        activeStatus = activeStatus,
        matchName = matchName,
        numberOfBetsAvailable = numberOfBetsAvailable,
        teamFirst = teamFirst,
        teamSecond = teamSecond
    )

}