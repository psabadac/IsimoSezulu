package com.sabadac.isimosezulu.data.source

import android.location.Location
import com.sabadac.isimosezulu.domain.model.Result
import com.sabadac.isimosezulu.data.api.WeatherApi
import com.sabadac.isimosezulu.data.model.WeatherApiModel

class WeatherRemoteDataSource(
    private val weatherApi: WeatherApi
) {
    suspend fun getWeather(location: Location): Result<WeatherApiModel> = try {
        Result.Success(
            weatherApi.getWeather(
                latitude = location.latitude,
                longitude = location.longitude
            )
        )
    } catch (e: Exception) {
        e.printStackTrace()
        Result.Error("Failed to get weather. " + e.message, e)
    }
}