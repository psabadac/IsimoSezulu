package com.sabadac.isimosezulu.domain.model

data class WeatherUiState(
    val weather: Weather,
    val forecasts: List<Forecast>
)