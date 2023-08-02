package com.example.weathertestapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weathertestapp.data.WeatherRepository
import com.example.weathertestapp.domain.WeatherEntity
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


class MainViewModel(private val repository: WeatherRepository) : ViewModel() {
    private val _weatherData = MutableStateFlow<List<WeatherEntity>?>(null)
    val weatherData: StateFlow<List<WeatherEntity>?> = _weatherData


    init {
        fetchWeatherData("63433dd7e9d0b1ce34323f1550c265f1")
    }
    private fun fetchWeatherData(apiKey: String) {
        viewModelScope.launch {
            try {
                val weatherList = repository.getWeatherForCities(apiKey)
                _weatherData.value = weatherList
            } catch (e: Exception) {
                // Обработка ошибок
            }
        }
    }
}