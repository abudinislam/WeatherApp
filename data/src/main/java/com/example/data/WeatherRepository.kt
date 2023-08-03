package com.example.data

import com.example.data.api.WeatherApi
import com.example.domain.WeatherEntity

class WeatherRepository(private val weatherApi: WeatherApi) {

    companion object {
        const val apiKey = "63433dd7e9d0b1ce34323f1550c265f1"
    }

    suspend fun getWeatherForCities(): List<WeatherEntity> {
        val cities = listOf("Almaty", "Astana", "Taraz")
        return cities.map { cityName ->
            val response = weatherApi.getWeather(cityName, apiKey)
            response.toEntity()
        }
    }

    suspend fun getWeatherForCity(cityName: String, days: Int): WeatherEntity? {
        return if (days <= 7) {
            val response = weatherApi.getWeeklyWeather(cityName, days, apiKey)
            response.toEntity()
        } else {
            val response = weatherApi.getMonthlyWeather(cityName, days, apiKey)
            response.toEntity()
        }
    }
}
