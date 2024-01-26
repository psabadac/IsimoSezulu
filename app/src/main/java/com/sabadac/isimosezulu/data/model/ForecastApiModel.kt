package com.sabadac.isimosezulu.data.model

import com.google.gson.annotations.SerializedName

data class ForecastApiModel(
      @SerializedName("list")
    val list: List<ForecastDay>,
)

data class ForecastDay(
    @SerializedName("temp")
    val temp: ForecastTemp,

    @SerializedName("weather")
    val weather: List<WeatherParam>,

    @SerializedName("dt")
    val dt: Long
)

data class ForecastTemp(
    @SerializedName("day")
    val day: Double
)