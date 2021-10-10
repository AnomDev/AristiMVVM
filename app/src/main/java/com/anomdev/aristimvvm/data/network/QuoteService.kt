package com.anomdev.aristimvvm.data.network

import com.anomdev.aristimvvm.core.RetrofitHelper
import com.anomdev.aristimvvm.data.model.QuoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class QuoteService {
    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getQuotes(): List<QuoteModel>{
        //Al estar usando corrutinas, hacemos que lo relativo a recuperar datos del servidor no se haga desde el main thread (encargado de la UI) sino desde uno secundario (working thread) que le quite responsabilidades.
        // Para ello utilizamos el Dispatchers.IO:
        return withContext(Dispatchers.IO){
            val response = retrofit.create(QuoteApiClient::class.java).getAllQuotes()
            response.body() ?: emptyList()
        }
        // Cuando la respuesta esté cargada, se la entregará a quien ejecute la función de getQuotes y así no saturamos el hilo de la interfaz de usuario.
    }
}