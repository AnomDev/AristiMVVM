package com.anomdev.aristimvvm.data

import com.anomdev.aristimvvm.data.model.QuoteModel
import com.anomdev.aristimvvm.data.model.QuoteProvider
import com.anomdev.aristimvvm.data.network.QuoteService

//Esta clase es la encargada de gestionar si se accede a los datos desde internet (network) o desde un fichero local (model)

class QuoteRepository {
    private val api = QuoteService()

    //Esta va a ser la clase a la que llamemos para que devuelva las citas
    suspend fun getAllQuotes():List<QuoteModel>{
        val response = api.getQuotes()
        QuoteProvider.quotes = response
        return response
    }
}