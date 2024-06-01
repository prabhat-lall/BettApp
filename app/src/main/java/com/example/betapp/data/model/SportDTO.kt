package com.example.betapp.data.model

import com.example.betapp.domain.model.Match
import com.example.betapp.domain.model.Sport
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class SportDTO(
    @SerializedName("image_id")
    val imageId: String,
    @SerializedName("image_name")
    val imageName: String,
    @SerializedName("image_src")
    val imageSrc: String,
    @SerializedName("sports_name")
    val sportsName: String
) : Serializable

fun SportDTO.toDomainSport() : Sport {
    return Sport(
        sportsName = sportsName
    )

}