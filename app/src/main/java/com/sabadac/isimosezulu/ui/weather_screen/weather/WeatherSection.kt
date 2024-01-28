package com.sabadac.isimosezulu.ui.weather_screen.weather

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sabadac.isimosezulu.data.Constants
import com.sabadac.isimosezulu.data.Constants.demoWeather
import com.sabadac.isimosezulu.domain.model.Weather

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
        HorizontalDivider(color = Color.White, thickness = 1.dp)
    }
}

@Preview(
    showSystemUi = true,
    showBackground = true,
    backgroundColor = Constants.demoBackgroundColor
)
@Composable
fun WeatherSectionPreview() {
    WeatherSection(
        weather = demoWeather,
        modifier = Modifier
    )
}