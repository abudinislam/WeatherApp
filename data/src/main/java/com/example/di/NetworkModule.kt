package com.example.di

import com.example.data.WeatherRepository
import com.example.data.api.WeatherApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val networkModule = module {

    single {
        val okHttp = OkHttpClient()
            .newBuilder()
            .addInterceptor(HttpLoggingInterceptor())
            .build()

        Retrofit.Builder()
            .client(okHttp)
            .baseUrl("https://api.openweathermap.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WeatherApi::class.java)
    }

    single { WeatherRepository(weatherApi = get()) }

}