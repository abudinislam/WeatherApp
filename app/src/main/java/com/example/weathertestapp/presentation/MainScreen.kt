package com.example.weathertestapp.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.domain.WeatherEntity
import org.koin.androidx.compose.getViewModel

@Preview(showBackground = true)
@Composable
fun WeatherApp() {
    val viewModel = getViewModel<MainViewModel>()
    val navController = rememberNavController()
    WeatherScreen(viewModel = viewModel, navController = navController)
}

@Composable
fun WeatherScreen(viewModel: MainViewModel, navController: NavController) {
    val weatherList by viewModel.weatherData.collectAsState()

    weatherList?.let { list ->
        Column {
            list.forEach { weather ->
                CityWeatherItem(weather) {
                    navController.navigate("details_screen/${weather.name}")
                }
            }
        }
    }
}

@Composable
fun CityWeatherItem(cityWeather: WeatherEntity, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable(onClick = onClick),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = cityWeather.name, fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Text(text = "${cityWeather.temperature}°C", fontSize = 20.sp)
    }
}