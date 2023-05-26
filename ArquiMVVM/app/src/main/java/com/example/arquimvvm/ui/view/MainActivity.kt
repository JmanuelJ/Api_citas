package com.example.arquimvvm.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.example.arquimvvm.databinding.ActivityMainBinding
import com.example.arquimvvm.ui.viewmodel.QuoteViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val quoteViewModel: QuoteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        quoteViewModel.onCreate()
        quoteViewModel.quoteModel.observe(this, Observer {curretQuote->
            binding.tvQuote.text = curretQuote.quote
            binding.tvAuthor.text =curretQuote.author
        })
        quoteViewModel.isLoadin.observe(this,Observer{
            binding.progress.isVisible = it
        })
        binding.viewContainer.setOnClickListener { quoteViewModel.randomQuote() }
    }
}