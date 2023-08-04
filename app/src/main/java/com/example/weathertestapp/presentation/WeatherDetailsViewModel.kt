package com.example.weathertestapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.WeatherRepository
import com.example.data.WeatherResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class WeatherDetailViewModel(
    private val repository: WeatherRepository
) : ViewModel() {

    private val _weatherDetail = MutableStateFlow<WeatherResponse?>(null)
    val weatherDetail: StateFlow<WeatherResponse?> = _weatherDetail

    private val _currentWeatherDetail = MutableStateFlow(WeatherResponse())
    val currentWeatherDetail: StateFlow<WeatherResponse> = _currentWeatherDetail

    private val _weeklyForecast = MutableStateFlow<List<WeatherResponse.ForecastDay>>(listOf())
    val weeklyForecast: StateFlow<List<WeatherResponse.ForecastDay>> = _weeklyForecast

    private val _monthlyForecast = MutableStateFlow<List<WeatherResponse.ForecastDay>>(listOf())
    val monthlyForecast: StateFlow<List<WeatherResponse.ForecastDay>> = _monthlyForecast

    private lateinit var cityName: String

    fun setCity(cityName: String) {
        this.cityName = cityName
        fetchWeatherDetail(cityName)
    }

    private fun fetchWeatherDetail(cityName: String) {
        viewModelScope.launch {
            try {
                _weatherDetail.value = repository.getWeatherForCity(cityName, 0)
            } catch (e: Exception) {
            }
        }
    }

    fun fetchWeeklyWeatherDetail(cityName: String) {
        viewModelScope.launch {
            try {
                _weeklyForecast.value =
                    repository.getWeatherForCity(cityName, 7).weeklyForecast ?: listOf()
            } catch (e: Exception) {
            }
        }
    }

    fun fetchMonthlyWeatherDetail(cityName: String) {
        viewModelScope.launch {
            try {
                _monthlyForecast.value =
                    repository.getWeatherForCity(cityName, 30).monthlyForecast ?: listOf()
            } catch (e: Exception) {
            }
        }
    }
}