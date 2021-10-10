package com.anomdev.aristimvvm.data.network

import com.anomdev.aristimvvm.data.model.QuoteModel
import retrofit2.Response
import retrofit2.http.GET


//Aquí configuraremos la llamada REST a la API.

interface QuoteApiClient {
    @GET("/.json")
    suspend fun getAllQuotes():Response<List<QuoteModel>>
}