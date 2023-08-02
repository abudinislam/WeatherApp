package com.example.weathertestapp.data

import com.example.weathertestapp.data.api.WeatherApi
import com.example.weathertestapp.domain.WeatherEntity

class WeatherRepository(private val weatherApi: WeatherApi) {

    suspend fun getWeatherForCities(apiKey: String): List<WeatherEntity> {
        val cities = listOf("Almaty", "Astana", "Taraz")
        return cities.map { cityName ->
            val response = weatherApi.getWeather(cityName, apiKey)
            response.toEntity()
        }
    }
}
