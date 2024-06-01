package com.example.betapp.data.model

import com.example.betapp.domain.model.HomeScreenModel
import java.io.Serializable

data class HomeScreenModelDTO(
    val matches: List<MatchDTO>,
    val sports: List<SportDTO>,
    val status: Int,
    val wallet: WalletDTO
) : Serializable


fun HomeScreenModelDTO.toDomainHomeScreenModel(): HomeScreenModel {
    return HomeScreenModel(
        matches = matches.map { it.toDomainMatch() },
        sports = sports.map { it.toDomainSport() },
        status = status,
        wallet = wallet.toDomainWallet()
    )
}