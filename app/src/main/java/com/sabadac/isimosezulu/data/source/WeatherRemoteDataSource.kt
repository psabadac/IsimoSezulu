package com.sabadac.isimosezulu.data.source

import com.sabadac.isimosezulu.domain.model.Result
import com.sabadac.isimosezulu.data.api.WeatherApi
import com.sabadac.isimosezulu.data.model.WeatherApiModel

class WeatherRemoteDataSource(
    private val weatherApi: WeatherApi
) {
    suspend fun getWeather(lat: Double, lon: Double): Result<WeatherApiModel> = try {
        Result.Success(weatherApi.getWeather(lat, lon))
    } catch (e: Exception) {
        Result.Error("Failed to get weather.", e)
    }
}