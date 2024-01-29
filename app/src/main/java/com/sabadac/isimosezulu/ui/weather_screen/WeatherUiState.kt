package com.sabadac.isimosezulu.ui.weather_screen

import com.sabadac.isimosezulu.domain.model.Forecast
import com.sabadac.isimosezulu.domain.model.Weather

data class WeatherUiState(
    val weather: Weather?,
    val forecasts: List<Forecast>?,
    val error: String?,
    val isLoading: Boolean = true,
)