package com.example.weathertestapp.presentation

sealed class Screen (val route: String) {
    object WeatherList : Screen("weather_list")
    data class WeatherDetail(val cityName: String) : Screen("weather_detail")
}