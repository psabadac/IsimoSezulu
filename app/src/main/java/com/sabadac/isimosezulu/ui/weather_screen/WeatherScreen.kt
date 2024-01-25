package com.sabadac.isimosezulu.ui.weather_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun WeatherScreen(
    weatherViewModel: WeatherViewModel = viewModel()
) {

    val weatherUiState by weatherViewModel.uiState.collectAsState()

    Column(modifier = Modifier.background(Color(weatherUiState.weather.color))) {
        WeatherSection(weather = weatherUiState.weather, modifier = Modifier)
    }
}

