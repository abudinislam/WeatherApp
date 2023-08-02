package com.example.weathertestapp.di

import android.app.Application
import com.example.weathertestapp.data.api.WeatherApi
import com.example.weathertestapp.data.api.weatherApi
import com.example.weathertestapp.presentation.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.GlobalContext.startKoin
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {
    single { weatherApi }
    viewModel { MainViewModel(api = get()) }
}

startKoin {
    modules(appModule)
}
