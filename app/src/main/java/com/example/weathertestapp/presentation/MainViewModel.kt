package com.example.weathertestapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weathertestapp.data.WeatherResponse
import com.example.weathertestapp.data.api.WeatherApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel(private val api: WeatherApi) : ViewModel() {

    private val _weatherList = MutableStateFlow<List<WeatherResponse>>(emptyList())
    val weatherList: StateFlow<List<WeatherResponse>> = _weatherList

    private val cities = listOf("Astana", "Almaty", "Taraz")

    init {
        fetchWeatherData()
    }

    private fun fetchWeatherData() {
        viewModelScope.launch {
            val weatherData = cities.mapNotNull { city ->
                try {
                    api.getWeatherForCity(city)
                } catch (e: Exception) {
                    null
                }
            }
            _weatherList.value = weatherData
        }
    }
}