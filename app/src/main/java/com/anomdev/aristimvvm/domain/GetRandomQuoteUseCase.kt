package com.anomdev.aristimvvm.domain

import com.anomdev.aristimvvm.data.model.QuoteModel
import com.anomdev.aristimvvm.data.model.QuoteProvider
import javax.inject.Inject

class GetRandomQuoteUseCase @Inject constructor(private val quoteProvider: QuoteProvider)  {
    operator fun invoke(): QuoteModel? {
        val quotes = quoteProvider.quotes
        if (!quotes.isNullOrEmpty()) {
            val randomize = (0..quotes.size - 1).random()
            return quotes[randomize]
        }
        return null
    }
}