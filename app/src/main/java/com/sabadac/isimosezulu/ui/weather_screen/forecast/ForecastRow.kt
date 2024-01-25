package com.sabadac.isimosezulu.ui.weather_screen.forecast

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.sabadac.isimosezulu.data.Forecast

@Composable
fun ForecastRow(
    forecast: Forecast,
    modifier: Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.padding(top = 4.dp, bottom = 4.dp)
    ) {
        Text(
            text = forecast.name,
            color = Color.White,
            modifier = Modifier
                .weight(1f)
                .padding(start = 16.dp)
        )
        Image(
            painter = painterResource(id = forecast.icon),
            contentDescription = forecast.status,
            contentScale = ContentScale.Fit,
            modifier = Modifier.weight(1f)
        )
        Text(
            text = forecast.temperature,
            color = Color.White,
            textAlign = TextAlign.End,
            modifier = Modifier
                .weight(1f)
                .padding(end = 16.dp)
        )
    }
}