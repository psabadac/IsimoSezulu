package com.sabadac.isimosezulu.ui.weather_screen

import com.sabadac.isimosezulu.data.Forecast
import com.sabadac.isimosezulu.data.Weather

data class WeatherUiState(
    val weather: Weather,
    val forecasts: List<Forecast>
)