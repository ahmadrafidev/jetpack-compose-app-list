package dev.ahmadrafi.weatherforecast.model
import WeatherObject
import dev.ahmadrafi.weatherforecast.model.FeelsLike
import dev.ahmadrafi.weatherforecast.model.Temp

data class WeatherItem(
    val clouds: Int,
    val deg: Int,
    val dt: Int,
    val feels_like: FeelsLike,
    val gust: Double,
    val humidity: Int,
    val pop: Double,
    val pressure: Int,
    val rain: Double,
    val speed: Double,
    val sunrise: Int,
    val sunset: Int,
    val temp: Temp,
    val weather: List<WeatherObject>
                      )