package com.example.betapp.presentation.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.betapp.domain.model.Match
import com.example.betapp.domain.model.Sport
import com.example.betapp.domain.model.Wallet
import com.example.betapp.domain.usecase.GetMatchListUseCase
import com.example.betapp.domain.usecase.GetSportListUseCase
import com.example.betapp.domain.usecase.GetUserWalletUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getMatchListUseCase: GetMatchListUseCase,
    private val getSportListUseCase: GetSportListUseCase,
    private val getUserWalletUseCase: GetUserWalletUseCase

    ) : ViewModel() {
    private val _matchListLiveData = MutableLiveData<List<Match>>()
    val matchLiveData: LiveData<List<Match>>
        get() = _matchListLiveData

    private val _sportsTypeListLiveData = MutableLiveData<List<Sport>>()
    val sportsTypeListLiveData: LiveData<List<Sport>>
        get() = _sportsTypeListLiveData

    private val _walletLiveData = MutableLiveData<Wallet>()
    val walletLiveData: LiveData<Wallet>
        get() = _walletLiveData

    fun fetchHomeScreenData(context : Context) {
        viewModelScope.launch {
            val response = getMatchListUseCase.invoke(context)
            _matchListLiveData.postValue(response.data?.matches)
            var list = mutableListOf<Sport>()
            list.addAll(response.data?.sports!!)
            list.add(Sport("Adding soon ..."))

            _sportsTypeListLiveData.postValue(list)
        }
    }

    fun fetchUserWallet(context: Context){
        viewModelScope.launch {
            val response = getUserWalletUseCase.invoke(context)
            _walletLiveData.postValue(response.data?.wallet)
        }
    }

}