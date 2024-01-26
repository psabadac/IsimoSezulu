package com.sabadac.isimosezulu.data.repository

import com.sabadac.isimosezulu.domain.model.Result
import com.sabadac.isimosezulu.domain.model.Weather
import com.sabadac.isimosezulu.data.mapper.WeatherMapper
import com.sabadac.isimosezulu.data.source.WeatherRemoteDataSource

class WeatherRepository(
    private val weatherRemoteDataSource: WeatherRemoteDataSource
) {
    suspend fun getWeather(lat: Double, lon: Double): Result<Weather> =
        WeatherMapper.mapFrom(weatherRemoteDataSource.getWeather(lat, lon))
}