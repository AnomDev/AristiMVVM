package com.anomdev.aristimvvm.di

import com.anomdev.aristimvvm.data.network.QuoteApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class) //Entre los paréntesis le decimos a Dagger qué alcance queremos que tenga este módulo. Si lo hacemos a nivel Activity, cuando la Activity necesite Retrofit, Dagger creará una instancia y se la va a dar. Cuando la Activity muera, la instancia morirán también.
object NetworkModule {

    //La etiqueta Singleton nos permite mantener una instancia (en este caso de Retrofit) permanente y así no tener que generar una nueva cada vez que se requiera Retrofit
    @Singleton
    @Provides
    fun provideRetrofit():Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://drawsomething-59328-default-rtdb.europe-west1.firebasedatabase.app/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideQuoteApiClient(retrofit: Retrofit):QuoteApiClient{
        return retrofit.create(QuoteApiClient::class.java)
    }

}