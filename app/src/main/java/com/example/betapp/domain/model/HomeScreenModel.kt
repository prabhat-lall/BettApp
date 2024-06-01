package com.example.betapp.domain.model

import java.io.Serializable

data class HomeScreenModel(
    val matches: List<Match>,
    val sports: List<Sport>,
    val status: Int,
    val wallet: Wallet
) : Serializable
