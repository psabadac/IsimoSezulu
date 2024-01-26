package com.sabadac.isimosezulu.data.model

import com.google.gson.annotations.SerializedName

data class WeatherApiModel(
    @SerializedName("weather")
    val weather: List<WeatherParam>,

    @SerializedName("main")
    val main: Main,
)

data class Main(
    @SerializedName("temp")
    val temp: Double,

    @SerializedName("temp_min")
    val tempMin: Double,

    @SerializedName("temp_max")
    val tempMax: Double,
)



