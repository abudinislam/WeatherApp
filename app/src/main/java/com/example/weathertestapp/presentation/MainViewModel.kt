package com.example.weathertestapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.WeatherRepository
import com.example.domain.WeatherEntity
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel(private val repository: WeatherRepository) : ViewModel() {

    private val _weatherData = MutableStateFlow<List<WeatherEntity>?>(null)
    val weatherData: StateFlow<List<WeatherEntity>?> = _weatherData

    init {
        fetchWeatherData()
    }
    private fun fetchWeatherData() {
        viewModelScope.launch {
            try {
                val weatherList = repository.getWeatherForCities()
                _weatherData.value = weatherList
            } catch (e: Exception) {
            }
        }
    }
}