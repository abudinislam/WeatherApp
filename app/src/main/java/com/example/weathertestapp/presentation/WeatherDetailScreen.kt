package com.example.weathertestapp.presentation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import org.koin.androidx.compose.getViewModel

@Composable
fun WeatherDetailScreen(cityName: String, temperature: String) {
    val viewModel: WeatherDetailViewModel = getViewModel()
    viewModel.setCity(cityName)
    val weatherDetail by viewModel.weatherDetail.collectAsState()

    weatherDetail?.let {
        Text(text = "${it.name}: ${it.temperature}°C")
    } ?: Text(text = "Loading...")

}
