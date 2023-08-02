package com.example.weathertestapp.data.api

import com.example.weathertestapp.data.WeatherResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("data/2.5/weather")
    suspend fun getWeatherForCity(
        @Query("q") city: String,
        @Query("appid") apiKey: String = "63433dd7e9d0b1ce34323f1550c265f1",
        @Query("units") units: String = "metric"
    ): WeatherResponse
}

val weatherRetrofit: Retrofit = Retrofit.Builder()
    .baseUrl("https://api.openweathermap.org/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

val weatherApi: WeatherApi = weatherRetrofit.create(WeatherApi::class.java)
