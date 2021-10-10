package com.anomdev.aristimvvm.domain

import com.anomdev.aristimvvm.data.QuoteRepository
import com.anomdev.aristimvvm.data.model.QuoteModel

class GetQuotesUseCase {
    private val repository = QuoteRepository()

    suspend operator fun invoke() : List<QuoteModel>?{
        return repository.getAllQuotes()
    }
}