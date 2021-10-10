package com.anomdev.aristimvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.anomdev.aristimvvm.model.QuoteModel
import com.anomdev.aristimvvm.model.QuoteProvider

class QuoteViewModel : ViewModel() {

    val quoteModel = MutableLiveData<QuoteModel>()

    fun randomQuote(){
        val currentQuote = QuoteProvider.randomize()
        quoteModel.postValue(currentQuote)
    }


}