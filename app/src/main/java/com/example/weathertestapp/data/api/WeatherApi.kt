package com.example.weathertestapp.data.api

import com.example.weathertestapp.data.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("data/2.5/weather")
    suspend fun getWeather(
        @Query("q") cityName: String,
        @Query("appid") apiKey: String
    ): WeatherResponse
}

//val weatherRetrofit: Retrofit = Retrofit.Builder()
//    .baseUrl("https://api.openweathermap.org/")
//    .addConverterFactory(GsonConverterFactory.create())
//    .build()
//
//val weatherApi: WeatherApi = weatherRetrofit.create(WeatherApi::class.java)
