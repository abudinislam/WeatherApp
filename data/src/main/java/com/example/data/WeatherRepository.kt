package com.example.data

import com.example.data.api.WeatherApi

class WeatherRepository(private val weatherApi: WeatherApi) {

    companion object {
        const val apiKey = "63433dd7e9d0b1ce34323f1550c265f1"
    }

    suspend fun getWeatherForCities(): List<WeatherResponse> {
        val cities = listOf("Almaty", "Astana", "Taraz")
        return cities.map { cityName ->
            weatherApi.getWeather(cityName, apiKey)
        }
    }

    suspend fun getWeatherForCity(cityName: String, days: Int): WeatherResponse {
        return if (days <= 7) {
            weatherApi.getWeeklyWeather(cityName, days, apiKey)
        } else {
            weatherApi.getMonthlyWeather(cityName, days, apiKey)
        }
    }
}
