package dev.ahmadrafi.weatherforecast.screens.main

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.ahmadrafi.weatherforecast.data.DataOrException
import dev.ahmadrafi.weatherforecast.model.Weather
import dev.ahmadrafi.weatherforecast.repository.WeatherRepository
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: WeatherRepository)
    : ViewModel(){

        suspend fun getWeatherData(city: String, units: String)
        : DataOrException<Weather, Boolean, Exception> {
            return repository.getWeather(cityQuery = city, units = units)
        }

}