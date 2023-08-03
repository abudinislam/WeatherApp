package com.example.weathertestapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.WeatherRepository
import com.example.domain.ForecastEntity
import com.example.domain.WeatherEntity
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class WeatherDetailViewModel(
    private val repository: WeatherRepository
) : ViewModel() {

    private val _weatherDetail = MutableStateFlow<WeatherEntity?>(null)
    val weatherDetail: StateFlow<WeatherEntity?> = _weatherDetail

    private val _currentWeatherDetail = MutableStateFlow<WeatherEntity?>(null)
    val currentWeatherDetail: StateFlow<WeatherEntity?> = _currentWeatherDetail

    private val _weeklyForecast = MutableStateFlow<List<ForecastEntity>?>(null)
    val weeklyForecast: StateFlow<List<ForecastEntity>?> = _weeklyForecast

    private val _monthlyForecast = MutableStateFlow<List<ForecastEntity>?>(null)
    val monthlyForecast: StateFlow<List<ForecastEntity>?> = _monthlyForecast

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


                // Assuming the repository has functions to fetch weekly and monthly forecasts directly
//                val weekly = repository.getWeatherForCity(cityName, 7)
//                _weeklyForecast.value = weekly?.weeklyForecast
//
//                val monthly = repository.getWeatherForCity(cityName, 30)
//                _monthlyForecast.value = monthly?.monthlyForecast
            } catch (e: Exception) {
                // Handle the exception, perhaps log it or inform the user
            }
        }
    }
}