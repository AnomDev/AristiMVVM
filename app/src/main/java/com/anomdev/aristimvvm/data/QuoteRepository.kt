package com.anomdev.aristimvvm.data

import com.anomdev.aristimvvm.data.model.QuoteModel
import com.anomdev.aristimvvm.data.model.QuoteProvider
import com.anomdev.aristimvvm.data.network.QuoteService
import javax.inject.Inject

//Esta clase es la encargada de gestionar si se accede a los datos desde internet (network) o desde un fichero local (model)

class QuoteRepository @Inject constructor(private val api : QuoteService, private val quoteProvider: QuoteProvider) {


    //Esta va a ser la clase a la que llamemos para que devuelva las citas
    suspend fun getAllQuotes():List<QuoteModel>{
        val response = api.getQuotes()
        quoteProvider.quotes = response
        return response
    }
}