package com.sabadac.isimosezulu.data.api

import com.sabadac.isimosezulu.data.model.WeatherApiModel
import retrofit2.http.GET
import retrofit2.http.Query
interface WeatherApi {
    @GET("data/2.5/weather")
    suspend fun getWeather(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
    ): WeatherApiModel
}