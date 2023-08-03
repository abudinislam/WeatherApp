package com.example.data.api

import com.example.data.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("data/2.5/weather")
    suspend fun getWeather(
        @Query("q") cityName: String,
        @Query("appid") apiKey: String,
    ): WeatherResponse

    @GET("data/2.5/forecast/daily")
    suspend fun getWeeklyWeather(
        @Query("q") cityName: String,
        @Query("cnt") count: Int = 7,
        @Query("appid") apiKey: String
    ): WeatherResponse

    @GET("data/2.5/forecast/daily")
    suspend fun getMonthlyWeather(
        @Query("q") cityName: String,
        @Query("cnt") count: Int = 30,
        @Query("appid") apiKey: String
    ): WeatherResponse
}