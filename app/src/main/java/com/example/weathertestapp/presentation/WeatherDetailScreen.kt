package com.example.weathertestapp.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.domain.ForecastEntity
import org.koin.androidx.compose.getViewModel

@Composable
fun WeatherDetailScreen(cityName: String, temperature: String) {
    val viewModel: WeatherDetailViewModel = getViewModel()
    viewModel.setCity(cityName)
    val weatherDetail by viewModel.weatherDetail.collectAsState()

    weatherDetail?.let {
        Text(text = "${it.name}: ${it.temperature}°C")
    } ?: Text(text = "Loading...")

    val weeklyForecast by viewModel.weeklyForecast.collectAsState()
    val monthlyForecast by viewModel.monthlyForecast.collectAsState()

    var tabIndex by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TabRow(
            selectedTabIndex = tabIndex,
            indicator = { tabPositions ->
                TabRowDefaults.Indicator(
                    Modifier.tabIndicatorOffset(tabPositions[tabIndex])
                )
            }
        ) {
            Tab(text = { Text("Неделя") },
                selected = tabIndex == 0,
                onClick = { tabIndex = 0 }
            )
            Tab(text = { Text("Месяц") },
                selected = tabIndex == 1,
                onClick = { tabIndex = 1 }
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        when (tabIndex) {
            0 -> ForecastList(forecast = weeklyForecast ?: emptyList())
            1 -> ForecastList(forecast = monthlyForecast ?: emptyList())
        }
    }
}

@Composable
fun ForecastList(forecast: List<ForecastEntity>) {
    LazyColumn {
        items(forecast) { dayForecast ->
            Text(text = "${dayForecast.day}: ${dayForecast.temperature}°C", style = MaterialTheme.typography.bodySmall)
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}