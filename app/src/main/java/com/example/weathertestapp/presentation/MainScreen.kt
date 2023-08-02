package com.example.weathertestapp.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weathertestapp.R

@Preview(showBackground = true)
@Composable
fun WeatherScreen(viewModel: MainViewModel = viewModel()) {
    val weatherList by viewModel.weatherList.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        weatherList.forEach { weather ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = weather.city, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                Text(text = "${weather.main.temp}°C", fontSize = 20.sp)
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
}