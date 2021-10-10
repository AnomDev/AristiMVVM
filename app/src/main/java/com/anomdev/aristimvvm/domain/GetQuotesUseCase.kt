package com.anomdev.aristimvvm.domain

import com.anomdev.aristimvvm.data.QuoteRepository
import com.anomdev.aristimvvm.data.model.QuoteModel
import javax.inject.Inject

class GetQuotesUseCase @Inject constructor(
    private val repository: QuoteRepository
) {

    suspend operator fun invoke() : List<QuoteModel>?{
        return repository.getAllQuotes()
    }
}