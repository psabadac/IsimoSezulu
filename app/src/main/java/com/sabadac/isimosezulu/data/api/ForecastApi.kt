package com.sabadac.isimosezulu.data.api

import com.sabadac.isimosezulu.data.model.ForecastApiModel
import retrofit2.http.GET
import retrofit2.http.Query

interface ForecastApi {
    @GET("data/2.5/forecast/daily?cnt=5")
    suspend fun getForecast(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
    ): ForecastApiModel
}