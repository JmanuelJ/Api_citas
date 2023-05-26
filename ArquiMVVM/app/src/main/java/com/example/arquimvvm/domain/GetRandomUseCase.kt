package com.example.arquimvvm.domain

import com.example.arquimvvm.data.model.QuoteModel
import com.example.arquimvvm.data.model.QuoteProvider

class GetRandomUseCase {
    operator fun invoke():QuoteModel?{
        val quotes = QuoteProvider.quotes
        if(!quotes.isNullOrEmpty()){
            //val randoNumber=(0..quotes.size-1).random()
            val randoNumber=(quotes.indices).random()
            return quotes[randoNumber]
        }
        return null
    }
}