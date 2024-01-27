package com.sabadac.isimosezulu.ui.weather_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.sabadac.isimosezulu.domain.model.Forecast
import com.sabadac.isimosezulu.domain.model.Weather
import com.sabadac.isimosezulu.ui.weather_screen.forecast.ForecastSection
import com.sabadac.isimosezulu.ui.weather_screen.weather.WeatherSection

@Composable
fun WeatherScreen(
    weather: Weather,
    forecasts: List<Forecast>
) {
    Column(modifier = Modifier.background(Color(weather.color))) {
        WeatherSection(weather = weather, modifier = Modifier)
        ForecastSection(forecasts = forecasts, modifier = Modifier.fillMaxHeight())
    }
}

