package com.sabadac.isimosezulu.data.repository

import com.sabadac.isimosezulu.domain.model.Forecast
import com.sabadac.isimosezulu.domain.model.Result
import com.sabadac.isimosezulu.data.mapper.ForecastMapper
import com.sabadac.isimosezulu.data.source.ForecastRemoteDataSource

class ForecastRepository(
    private val forecastRemoteDataSource: ForecastRemoteDataSource
) {
    suspend fun getForecast(lat: Double, lon: Double): Result<List<Forecast>> =
        ForecastMapper.mapFrom(forecastRemoteDataSource.getForecast(lat, lon))
}