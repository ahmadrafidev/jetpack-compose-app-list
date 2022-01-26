package dev.ahmadrafi.weatherforecast.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.bawp.jetweatherforecast.model.Favorite

@Database(entities = [Favorite::class, Unit::class], version = 2, exportSchema = false)
abstract class WeatherDatabase: RoomDatabase() {
    abstract fun weatherDao(): WeatherDao
}