package com.sabadac.isimosezulu.ui.weather_screen.weather

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sabadac.isimosezulu.R
import com.sabadac.isimosezulu.data.Constants
import com.sabadac.isimosezulu.data.Constants.demoWeather
import com.sabadac.isimosezulu.domain.model.Weather

@Composable
fun WeatherRow(
    weather: Weather,
    modifier: Modifier
) {
    Row(verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.padding(top = 8.dp, bottom = 10.dp)) {

        Column(modifier = Modifier
            .weight(1f)
            .padding(start = 16.dp)) {
            Text(
                text = stringResource(id = R.string.degree, weather.min),
                color = Color.White
            )
            Text(
                text = stringResource(id = R.string.min).lowercase(),
                color = Color.White
            )
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.weight(1f)) {
            Text(
                text = stringResource(id = R.string.degree, weather.current),
                color = Color.White
            )
            Text(
                text = stringResource(id = R.string.current).lowercase(),
                color = Color.White
            )
        }

        Column(
            horizontalAlignment = Alignment.End,
            modifier = Modifier
                .weight(1f)
                .padding(end = 16.dp)) {
            Text(
                text = stringResource(id = R.string.degree, weather.max),
                color = Color.White
            )
            Text(
                text = stringResource(id = R.string.max).lowercase(),
                color = Color.White
            )
        }
    }
}

@Preview(
    showSystemUi = true,
    showBackground = true,
    backgroundColor = Constants.demoBackgroundColor
)
@Composable
fun WeatherRowPreview() {
    WeatherRow(
        weather = demoWeather,
        modifier = Modifier
    )
}