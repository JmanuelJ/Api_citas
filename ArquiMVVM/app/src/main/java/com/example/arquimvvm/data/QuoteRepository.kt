package com.example.arquimvvm.data

import com.example.arquimvvm.data.model.QuoteModel
import com.example.arquimvvm.data.model.QuoteProvider
import com.example.arquimvvm.data.model.network.QuoteService

class QuoteRepository {
    private val api = QuoteService()

    suspend fun getAllQuotes(): List<QuoteModel>{
        val response = api.getQuotes()
        QuoteProvider.quotes = response
        return response
    }
}