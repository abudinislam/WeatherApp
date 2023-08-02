package com.example.weathertestapp.di

import com.example.weathertestapp.data.WeatherRepository
import com.example.weathertestapp.data.api.WeatherApi
import com.example.weathertestapp.presentation.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {

        // Ретрофит API
        single {
            Retrofit.Builder()
                .baseUrl("https://api.openweathermap.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(WeatherApi::class.java)
        }

        // Репозиторий
        single { WeatherRepository(weatherApi = get ()) }

        // ViewModel
        viewModel { MainViewModel(repository = get()) }
    }
