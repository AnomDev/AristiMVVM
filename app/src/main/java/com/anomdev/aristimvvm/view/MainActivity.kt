package com.anomdev.aristimvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.anomdev.aristimvvm.databinding.ActivityMainBinding
import com.anomdev.aristimvvm.viewmodel.QuoteViewModel

class MainActivity : AppCompatActivity() {

    //Preparamos el binding para que coja las vistas del XML desde código
    private lateinit var binding:ActivityMainBinding

    //Con esta línea, gracias a las dependencias de Activity y Fragment que pusimos, se va a hacer toda la conexión del ViewModel a la Activity de forma automática (el ciclo de vida, etc)
    private val quoteViewModel : QuoteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        quoteViewModel.quoteModel.observe(this, Observer { currentQuote ->
            binding.tvQuote.text = currentQuote.quote
            binding.tvAuthor.text = currentQuote.author
        })

        binding.viewContainer.setOnClickListener{
            quoteViewModel.randomQuote()
        }
    }
}