package com.example.data.api

import com.example.data.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("weather")
    suspend fun getWeather(
        @Query("q") cityName: String,
        @Query("appid") apiKey: String,
        @Query("units") units: String = "metric",
    ): WeatherResponse

    @GET("forecast/daily")
    suspend fun getWeeklyWeather(
        @Query("q") cityName: String,
        @Query("cnt") count: Int = 6,
        @Query("appid") apiKey: String,
        @Query("units") units: String = "metric",
    ): WeatherResponse

    @GET("forecast/climate")
    suspend fun getMonthlyWeather(
        @Query("q") cityName: String,
        @Query("cnt") count: Int = 5,
        @Query("appid") apiKey: String
    ): WeatherResponse
}