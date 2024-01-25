package com.sabadac.isimosezulu.ui.weather_screen

import androidx.lifecycle.ViewModel
import com.sabadac.isimosezulu.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class WeatherViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(
        WeatherUiState(
            weather = Weather(
                image = R.drawable.forest_cloudy,
                color = R.color.cloudy,
                status = "CLOUDY",
                min = "18°",
                current = "24°",
                max = "26°"
            )
        )
    )
    val uiState: StateFlow<WeatherUiState> = _uiState.asStateFlow()
}