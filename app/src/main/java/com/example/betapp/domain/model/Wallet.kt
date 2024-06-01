package com.example.betapp.domain.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Wallet(
    val coinAmount: Int
) : Serializable