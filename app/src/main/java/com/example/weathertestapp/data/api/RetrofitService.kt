package com.example.weathertestapp.data.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {

private const val BASE_URL = "https://api.openweathermap.org/"

    fun getPostApi(): WeatherApi {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(WeatherApi::class.java)

        val apiService: WeatherApi = retrofit.create(WeatherApi::class.java)

    }

}