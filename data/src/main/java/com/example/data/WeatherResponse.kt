package com.example.data

import com.example.domain.WeatherEntity

data class WeatherResponse(
    val name: String,
    val main: Main,
) {
    data class Main(
        val temp: Double,
    )
}

fun WeatherResponse.toEntity(): WeatherEntity {
    return WeatherEntity(
        name = this.name,
        temperature = this.main.temp,
    )
}