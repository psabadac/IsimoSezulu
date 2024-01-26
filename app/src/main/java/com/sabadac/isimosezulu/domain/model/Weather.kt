package com.sabadac.isimosezulu.domain.model

data class Weather(
    val image: Int,
    val color: Int,
    val status: String,
    val min: String,
    val current: String,
    val max: String,
)