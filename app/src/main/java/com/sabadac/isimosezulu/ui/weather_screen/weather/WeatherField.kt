package com.sabadac.isimosezulu.ui.weather_screen.weather

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sabadac.isimosezulu.R
import com.sabadac.isimosezulu.domain.model.Weather

@Composable
fun WeatherField(
    weather: Weather,
    modifier: Modifier
) {
    Box(modifier = modifier) {
        Image(
            painter = painterResource(id = weather.image),
            contentScale = ContentScale.FillWidth,
            contentDescription = "",
            modifier = Modifier.fillMaxWidth()
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 80.dp)
        ) {
            Text(
                text = stringResource(id = R.string.degree, weather.current),
                fontSize = 40.sp,
                color = Color.White
            )
            Text(
                text = weather.status.uppercase(),
                fontSize = 30.sp,
                color = Color.White
            )
        }
    }
}