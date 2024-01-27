package com.sabadac.isimosezulu.ui.weather_screen

import android.location.Location
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.sabadac.isimosezulu.ui.weather_screen.forecast.ForecastSection
import com.sabadac.isimosezulu.ui.weather_screen.weather.WeatherSection
import org.koin.androidx.compose.koinViewModel

@Composable
fun WeatherScreen(
    location: Location,
    weatherViewModel: WeatherViewModel = koinViewModel()
) {

    val weatherUiState by weatherViewModel.uiState.collectAsState()

    LaunchedEffect(Unit) {
        weatherViewModel.getWeather(
            lat = location.latitude,
            lon = location.longitude
        )
    }

    Column(modifier = Modifier.background(Color(weatherUiState.weather.color))) {
        WeatherSection(weather = weatherUiState.weather, modifier = Modifier)
        ForecastSection(forecasts = weatherUiState.forecasts, modifier = Modifier.fillMaxHeight())
    }
}

