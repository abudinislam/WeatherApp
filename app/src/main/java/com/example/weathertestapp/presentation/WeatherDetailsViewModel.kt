package com.example.weathertestapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.WeatherRepository
import com.example.domain.WeatherEntity
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class WeatherDetailViewModel(
    private val repository: WeatherRepository
) : ViewModel() {

    private val _weatherDetail = MutableStateFlow<WeatherEntity?>(null)
    val weatherDetail: StateFlow<WeatherEntity?> = _weatherDetail

    private lateinit var cityName: String

    fun setCity(cityName: String) {
        this.cityName = cityName
        fetchWeatherDetail(cityName)
    }

    private fun fetchWeatherDetail(cityName: String) {
        viewModelScope.launch {
            try {
                val weather = repository.getWeatherForCity(cityName)
                _weatherDetail.value = weather
            } catch (e: Exception) {
            }
        }
    }
}