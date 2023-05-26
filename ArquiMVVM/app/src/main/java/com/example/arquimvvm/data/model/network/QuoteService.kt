package com.example.arquimvvm.data.model.network

import com.example.arquimvvm.core.RetrofitHelper
import com.example.arquimvvm.data.model.QuoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class QuoteService {
    private val retofit = RetrofitHelper.getRetrofit()
    suspend fun getQuotes(): List<QuoteModel>{
        return withContext(Dispatchers.IO){
            val response = retofit.create(QuoteApiClient::class.java).getAllQuotes()
            response.body() ?: emptyList()
        }
    }
}