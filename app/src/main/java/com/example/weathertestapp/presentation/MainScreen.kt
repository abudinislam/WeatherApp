package com.example.weathertestapp.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.lifecycle.viewmodel.compose.viewModel

@Preview(showBackground = true)
@Composable
fun WeatherApp() {
    val viewModel: MainViewModel by viewModel()
    WeatherScreen(viewModel = viewModel)
}

@Composable
fun WeatherScreen(viewModel: MainViewModel = viewModel()) {
    val weatherList by viewModel.weatherData.collectAsState()

    weatherList?.let { list ->
        Column {
            list.forEach { weather ->
                Text(text = "${weather.name}: ${weather.temperature}°C")
            }
        }
    }
}

//    Image(
//        modifier = Modifier.fillMaxSize(),
//        contentScale = ContentScale.FillBounds,
//        painter = painterResource(id = R.drawable.weather_icon),
//        contentDescription = null
//    )
////    Box(modifier = Modifier
////        .fillMaxSize()
////        .background(color = colorResource(id =  R.color.purple_500)))
//
//    Column(modifier = Modifier.fillMaxSize()) {
//
//        Card(
//            modifier = Modifier
//                .fillMaxWidth()
//                .background(color = colorResource(id = R.color.teal_200)),
//            shape = RoundedCornerShape(10.dp)
////            elevation = 0.dp,
//
//        ) {
//        }
//    }
