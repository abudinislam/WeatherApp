package com.example.data

import com.example.domain.ForecastEntity
import com.example.domain.WeatherEntity

data class WeatherResponse(
    val name: String,
    val main: Main,
    val weeklyForecast: List<ForecastDay>,
    val monthlyForecast: List<ForecastDay>
) {
    data class Main(
        val temp: Double
    )

    data class ForecastDay(
        val dt: Long,
        val main: Main
    )
}

fun WeatherResponse.toEntity(): WeatherEntity {
    return WeatherEntity(
        name = this.name,
        temperature = this.main.temp,
//        weeklyForecast = this.weeklyForecast.map { forecastDay ->
//            ForecastEntity(
//                day = forecastDay.dt.toString(),
//                temperature = forecastDay.main.temp
//            )
//        },
//        monthlyForecast = this.monthlyForecast.map { forecastDay ->
//            ForecastEntity(
//                day = forecastDay.dt.toString(),
//                temperature = forecastDay.main.temp
//            )
//        }
    )
}