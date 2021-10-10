package com.anomdev.aristimvvm.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.anomdev.aristimvvm.data.model.QuoteModel
import com.anomdev.aristimvvm.data.model.QuoteProvider
import com.anomdev.aristimvvm.domain.GetQuotesUseCase
import com.anomdev.aristimvvm.domain.GetRandomQuoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuoteViewModel @Inject constructor(
    //Aquí podemos inyectar las clases que queramos:
    private val getQuotesUseCase: GetQuotesUseCase,
    private val getRandomQuoteUseCase: GetRandomQuoteUseCase
) : ViewModel() {

    val quoteModel = MutableLiveData<QuoteModel>()
    val isLoading = MutableLiveData<Boolean>()


    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getQuotesUseCase()

            if (!result.isNullOrEmpty()) {
                quoteModel.postValue(result[0])
                isLoading.postValue(false)
            }
        }
    }

    fun randomQuote() {

        isLoading.postValue(true)

        val quote = getRandomQuoteUseCase()
        if (quote != null)
            quoteModel.postValue(quote)

        isLoading.postValue(false)

    }


}