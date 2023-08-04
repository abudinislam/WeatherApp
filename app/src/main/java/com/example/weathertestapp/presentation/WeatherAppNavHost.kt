package com.example.weathertestapp.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import org.koin.androidx.compose.getViewModel

@Composable
fun WeatherAppNavHost() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.WeatherList.route) {
        composable(route = Screen.WeatherList.route) {
            val viewModel = getViewModel<MainViewModel>()
            WeatherScreen(viewModel = viewModel, navController = navController)
        }
        composable(
            route = "weather_detail/{cityName}",
            arguments = listOf(navArgument("cityName") { type = NavType.StringType })
        ) { backStackEntry ->
            val cityName = backStackEntry.arguments?.getString("cityName")
            cityName?.let {
                WeatherDetailScreen(cityName = cityName)
            }
        }
    }
}
