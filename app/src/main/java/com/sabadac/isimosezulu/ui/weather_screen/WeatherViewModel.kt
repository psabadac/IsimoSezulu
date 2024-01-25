package com.sabadac.isimosezulu.ui.weather_screen

import androidx.lifecycle.ViewModel
import com.sabadac.isimosezulu.R
import com.sabadac.isimosezulu.data.Forecast
import com.sabadac.isimosezulu.data.Weather
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class WeatherViewModel : ViewModel() {
    private val demoWeather = Weather(
        image = R.drawable.forest_cloudy,
        color = R.color.cloudy,
        status = "CLOUDY",
        min = "18°",
        current = "24°",
        max = "26°"
    )
    private val demoForecasts = listOf(
        Forecast(
            name = "Monday",
            icon = R.drawable.weather_ic_01d,
            status = "Snow",
            temperature = "19°"
        ),
        Forecast(
            name = "Tuesday",
            icon = R.drawable.weather_ic_02d,
            status = "Snow",
            temperature = "18°"
        ),
        Forecast(
            name = "Wednesday",
            icon = R.drawable.weather_ic_03d,
            status = "Snow",
            temperature = "15°"
        ),
        Forecast(
            name = "Thursday",
            icon = R.drawable.weather_ic_04d,
            status = "Snow",
            temperature = "17°"
        ),
        Forecast(
            name = "Friday",
            icon = R.drawable.weather_ic_09d,
            status = "Snow",
            temperature = "19°"
        )
    )
    private val _uiState = MutableStateFlow(
        WeatherUiState(
            weather = demoWeather,
            forecasts = demoForecasts
        )
    )
    val uiState: StateFlow<WeatherUiState> = _uiState.asStateFlow()
}