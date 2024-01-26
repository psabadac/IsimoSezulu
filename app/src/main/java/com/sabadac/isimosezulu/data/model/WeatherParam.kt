package com.sabadac.isimosezulu.data.model

import com.google.gson.annotations.SerializedName

data class WeatherParam(
    @SerializedName("id")
    val id: Int,

    @SerializedName("main")
    val main: String,

    @SerializedName("icon")
    val icon: String
)