package com.example.betapp.domain.repository

import android.content.Context
import com.example.betapp.domain.model.HomeScreenModel
import com.example.betapp.utlis.Response

interface MainRepository {

    suspend fun getMatchesFromLocalJson(context: Context): Response<HomeScreenModel>

}