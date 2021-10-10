package com.anomdev.aristimvvm.domain

import com.anomdev.aristimvvm.data.model.QuoteModel
import com.anomdev.aristimvvm.data.model.QuoteProvider

class GetRandomQuoteUseCase {
    operator fun invoke(): QuoteModel? {
        val quotes = QuoteProvider.quotes
        if (!quotes.isNullOrEmpty()) {
            val randomize = (0..quotes.size - 1).random()
            return quotes[randomize]
        }
        return null
    }
}