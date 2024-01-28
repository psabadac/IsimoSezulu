package com.sabadac.isimosezulu.data.source

import android.location.Location
import com.sabadac.isimosezulu.domain.model.Result
import com.sabadac.isimosezulu.data.api.ForecastApi
import com.sabadac.isimosezulu.data.model.ForecastApiModel

class ForecastRemoteDataSource(
    private val forecastApi: ForecastApi
) {
    suspend fun getForecast(location: Location): Result<ForecastApiModel> = try {
        Result.Success(
            forecastApi.getForecast(
                latitude = location.latitude,
                longitude = location.longitude)
        )
    } catch (e: Exception) {
        Result.Error("Failed to get forecast. " + e.message, e)
    }
}