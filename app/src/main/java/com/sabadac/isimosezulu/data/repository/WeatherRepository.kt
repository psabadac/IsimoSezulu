package com.sabadac.isimosezulu.data.repository

import android.location.Location
import com.sabadac.isimosezulu.domain.model.Result
import com.sabadac.isimosezulu.domain.model.Weather
import com.sabadac.isimosezulu.data.mapper.WeatherMapper
import com.sabadac.isimosezulu.data.source.WeatherRemoteDataSource

class WeatherRepository(
    private val weatherRemoteDataSource: WeatherRemoteDataSource
) {
    suspend fun getWeather(location: Location): Result<Weather> =
        WeatherMapper.mapFrom(
            weatherRemoteDataSource.getWeather(
                location = location
            )
        )
}