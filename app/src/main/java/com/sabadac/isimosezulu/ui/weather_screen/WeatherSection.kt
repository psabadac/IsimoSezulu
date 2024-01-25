package com.sabadac.isimosezulu.ui.weather_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun WeatherSection(
    weather: Weather,
    modifier: Modifier
) {
    Column(modifier = modifier) {
        WeatherField(weather = weather, modifier = Modifier)
    }
}

