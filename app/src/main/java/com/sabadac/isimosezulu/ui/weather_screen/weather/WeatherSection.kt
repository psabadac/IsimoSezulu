package com.sabadac.isimosezulu.ui.weather_screen.weather

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.sabadac.isimosezulu.data.Weather

@Composable
fun WeatherSection(
    weather: Weather,
    modifier: Modifier
) {
    Column(modifier = modifier) {
        WeatherField(
            weather = weather,
            modifier = Modifier
        )
        WeatherRow(
            weather = weather,
            modifier = Modifier
        )
        Divider(color = Color.White, thickness = 1.dp)
    }
}

