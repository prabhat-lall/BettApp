package com.example.betapp.domain.usecase

import android.content.Context
import com.example.betapp.domain.model.HomeScreenModel
import com.example.betapp.domain.repository.MainRepository
import com.example.betapp.utlis.Response
import javax.inject.Inject

class GetUserWalletUseCase @Inject constructor(
    private val repository: MainRepository
) {
    suspend operator fun invoke(context: Context): Response<HomeScreenModel> {
        return repository.getMatchesFromLocalJson(context)
    }
}