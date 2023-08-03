package com.example.weathertestapp.di

import com.example.weathertestapp.presentation.MainViewModel
import com.example.weathertestapp.presentation.WeatherDetailViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel { MainViewModel(repository = get()) }
    viewModel { WeatherDetailViewModel(repository = get()) }
}
