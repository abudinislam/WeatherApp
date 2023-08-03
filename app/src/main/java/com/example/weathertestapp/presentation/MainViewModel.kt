package com.example.weathertestapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.WeatherRepository
import com.example.data.WeatherResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel(private val repository: WeatherRepository) : ViewModel() {

    private val _weatherData = MutableStateFlow<List<WeatherResponse>?>(listOf())
    val weatherData: StateFlow<List<WeatherResponse>?> = _weatherData

    init {
        fetchWeatherData()
    }

    private fun fetchWeatherData() {
        viewModelScope.launch {
            try {
                _weatherData.value = repository.getWeatherForCities()
            } catch (e: Exception) {
            }
        }
    }
}