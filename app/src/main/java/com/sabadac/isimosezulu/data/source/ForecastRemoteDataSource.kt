package com.sabadac.isimosezulu.data.source

import com.sabadac.isimosezulu.domain.model.Result
import com.sabadac.isimosezulu.data.api.ForecastApi
import com.sabadac.isimosezulu.data.model.ForecastApiModel

class ForecastRemoteDataSource(
    private val forecastApi: ForecastApi
) {
    suspend fun getForecast(lat: Double, lon: Double): Result<ForecastApiModel> = try {
        Result.Success(forecastApi.getForecast(lat, lon))
    } catch (e: Exception) {
        Result.Error("Failed to get forecast.", e)
    }
}