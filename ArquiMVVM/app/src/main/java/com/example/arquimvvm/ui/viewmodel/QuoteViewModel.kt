package com.example.arquimvvm.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.arquimvvm.data.model.QuoteModel
import com.example.arquimvvm.data.model.QuoteProvider
import com.example.arquimvvm.domain.GetQuotesUseCase
import com.example.arquimvvm.domain.GetRandomUseCase
import kotlinx.coroutines.launch

class QuoteViewModel: ViewModel(){
    val quoteModel = MutableLiveData<QuoteModel>()
    val isLoadin = MutableLiveData<Boolean>()
    var getQuotesUseCase = GetQuotesUseCase()
    var getRandomUseCase = GetRandomUseCase()

    fun onCreate() {
        viewModelScope.launch {
            isLoadin.postValue(true)
            val result = getQuotesUseCase()
            if(!result.isNullOrEmpty()){
                quoteModel.postValue(result[0])
                isLoadin.postValue(false)
            }
        }
    }

    fun randomQuote(){
        isLoadin.postValue(true)
        val quote = getRandomUseCase()
        if(quote != null){
            quoteModel.postValue(quote!!)
        }
        isLoadin.postValue(false)
    }

}