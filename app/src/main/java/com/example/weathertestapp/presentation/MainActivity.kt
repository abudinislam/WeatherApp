package com.example.weathertestapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.koin.androidx.compose.getViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {

    val viewModel: MainViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "main_screen") {
                composable("main_screen") {
                    val viewModel = getViewModel<MainViewModel>()
                    WeatherScreen(viewModel = viewModel, navController = navController)
                }
                composable("details_screen/{name}") { backStackEntry ->
                    val cityName = backStackEntry.arguments?.getString("name")
                    WeatherDetailScreen(cityName = cityName!!)
                }

            }
        }
    }
}
