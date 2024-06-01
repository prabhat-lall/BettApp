package com.example.betapp.data.repository

import android.content.Context
import android.util.Log
import com.example.betapp.data.model.HomeScreenModelDTO
import com.example.betapp.data.model.WalletDTO
import com.example.betapp.data.model.toDomainHomeScreenModel
import com.example.betapp.domain.model.HomeScreenModel
import com.example.betapp.domain.repository.MainRepository
import com.example.betapp.utlis.Response
import com.google.gson.Gson
import java.io.IOException
import java.io.InputStream

class MainRepositoryImpl : MainRepository {
    override suspend fun getMatchesFromLocalJson(context : Context): Response<HomeScreenModel> {

        var homeScreenModelDTO = HomeScreenModelDTO(emptyList(), emptyList(), 0, WalletDTO(0))

        try {
            val inputStream: InputStream = context.assets.open("data.json")
            val size: Int = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            val jsonString = String(buffer, Charsets.UTF_8)

            val gson = Gson()
            homeScreenModelDTO = gson.fromJson(jsonString, HomeScreenModelDTO::class.java)
        } catch (e: IOException) {
            Log.d(MainRepository::class.java.simpleName, "getMatchesFromLocalJson: ${e.localizedMessage}")
        }

        return Response.Success(homeScreenModelDTO.toDomainHomeScreenModel())
    }

}