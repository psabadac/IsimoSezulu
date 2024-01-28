package com.sabadac.isimosezulu.ui.location_screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.sabadac.isimosezulu.ui.weather_screen.WeatherScreen
import com.sabadac.isimosezulu.ui.weather_screen.WeatherViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun CurrentLocationScreen(
    weatherViewModel: WeatherViewModel = koinViewModel()
) {
    val weatherUiState by weatherViewModel.uiState.collectAsState()

    if (weatherUiState.isLoading) {
        CircularInfiniteLoading()

        LaunchedEffect(Unit) {
            weatherViewModel.getWeather()
        }
    } else if(weatherUiState.error != null) {
        ErrorDialog(weatherUiState.error!!) {
            weatherViewModel.retry()
        }
    } else {
        WeatherScreen(
            weather = weatherUiState.weather!!,
            forecasts = weatherUiState.forecasts!!
        )
    }
}