package com.example.weathertestapp.data

data class WeatherResponse(
    val city: String,
    val main: TemperatureInfo
)

data class TemperatureInfo(
    val temp: Double
)