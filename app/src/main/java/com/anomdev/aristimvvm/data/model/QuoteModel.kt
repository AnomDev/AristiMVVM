package com.anomdev.aristimvvm.data.model

import com.google.gson.annotations.SerializedName

data class QuoteModel(
    // Vamos a usar el QuoteModel como respuesta de Retrofit y la información que nos llegue la vamos a convertir a estos parámetros. Por eso los nombres han de ser iguales, para evitar que no sea así, utilizamos lo de @SerializedName
    @SerializedName("quote") val quote: String,
    @SerializedName("author") val author: String
)
