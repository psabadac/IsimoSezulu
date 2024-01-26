package com.sabadac.isimosezulu.domain.model

data class Forecast(
    val name: String,
    val icon: Int,
    val status: String,
    val temperature: String
)