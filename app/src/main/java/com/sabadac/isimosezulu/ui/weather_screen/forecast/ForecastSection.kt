package com.sabadac.isimosezulu.ui.weather_screen.forecast

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.lazy.items
import com.sabadac.isimosezulu.domain.model.Forecast

@Composable
fun ForecastSection(
    forecasts: List<Forecast>,
    modifier: Modifier
) {
    LazyColumn(modifier = modifier) {
        items(forecasts) {
            ForecastRow(forecast = it, modifier = Modifier)
        }
    }
}