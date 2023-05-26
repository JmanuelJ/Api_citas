package com.example.arquimvvm.domain

import com.example.arquimvvm.data.QuoteRepository
import com.example.arquimvvm.data.model.QuoteModel

class GetQuotesUseCase {
    private val repository = QuoteRepository()
    /*
    suspend operator fun invoke(): List<QuoteModel>?{
    return repository.getAllQuotes()
    }
    */
    suspend operator fun invoke(): List<QuoteModel>?=repository.getAllQuotes()

}