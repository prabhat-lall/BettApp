package com.example.betapp.data.model

import com.example.betapp.domain.model.Sport
import com.example.betapp.domain.model.Wallet
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class WalletDTO(
    @SerializedName("coin_amount")
    val coinAmount: Int
) : Serializable


fun WalletDTO.toDomainWallet() : Wallet {
    return Wallet(
        coinAmount = coinAmount
    )

}