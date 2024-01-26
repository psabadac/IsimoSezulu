package com.sabadac.isimosezulu.ui.weather_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.sabadac.isimosezulu.ui.weather_screen.forecast.ForecastSection
import com.sabadac.isimosezulu.ui.weather_screen.weather.WeatherSection
import org.koin.androidx.compose.koinViewModel

@Composable
fun WeatherScreen(
    weatherViewModel: WeatherViewModel = koinViewModel()
) {

    val weatherUiState by weatherViewModel.uiState.collectAsState()

    Column(modifier = Modifier.background(Color(weatherUiState.weather.color))) {
        WeatherSection(weather = weatherUiState.weather, modifier = Modifier.clickable {
            weatherViewModel.getWeather(47.0983, 27.5598)
        })
        ForecastSection(forecasts = weatherUiState.forecasts, modifier = Modifier.fillMaxHeight())
    }
}

