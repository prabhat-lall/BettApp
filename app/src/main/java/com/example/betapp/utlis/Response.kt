package com.example.betapp.utlis

sealed class Response<T>(val data: T? = null,var errorMessage: String?=null) {
    class Success<T>(data : T?) : Response<T>(data = data)
    class Loading<T> : Response<T>()
    class Failure<T>(errorMessage: String) : Response<T>(errorMessage = errorMessage)
}