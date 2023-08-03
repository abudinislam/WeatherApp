package com.example.data

data class WeatherResponse(
    val name: String? = null,
    val main: Main? = null,
    val weeklyForecast: List<ForecastDay>? = null,
    val monthlyForecast: List<ForecastDay>? = null,
) {
    data class Main(
        val temp: Double
    )

    data class ForecastDay(
        val dt: Long,
        val main: Main
    )
}