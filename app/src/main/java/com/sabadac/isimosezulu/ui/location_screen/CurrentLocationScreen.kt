package com.sabadac.isimosezulu.ui.location_screen

import android.Manifest
import android.location.Location
import androidx.annotation.RequiresPermission
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.Priority
import com.google.android.gms.tasks.CancellationTokenSource
import com.sabadac.isimosezulu.ui.weather_screen.WeatherScreen
import com.sabadac.isimosezulu.ui.weather_screen.WeatherViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
import org.koin.androidx.compose.koinViewModel

@RequiresPermission(
    anyOf = [Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION],
)
@Composable
fun CurrentLocationScreen(
    weatherViewModel: WeatherViewModel = koinViewModel()
) {
    var location by remember { mutableStateOf<Location?>(null) }
    val context = LocalContext.current
    val locationClient = remember {
        LocationServices.getFusedLocationProviderClient(context)
    }

    LaunchedEffect(Unit) {
        withContext(Dispatchers.IO) {
            location = locationClient.getCurrentLocation(
                Priority.PRIORITY_BALANCED_POWER_ACCURACY,
                CancellationTokenSource().token
            ).await()
        }
    }

    location?.let { loc ->
        val weatherUiState by weatherViewModel.uiState.collectAsState()

        LaunchedEffect(Unit) {
            weatherViewModel.getWeather(
                lat = loc.latitude,
                lon = loc.longitude
            )
        }

        val weather = weatherUiState.weather
        val forecasts = weatherUiState.forecasts

        if (weather == null && forecasts == null) {
            Box(modifier = Modifier.fillMaxSize()) {
                CircularProgressIndicator(
                    color = MaterialTheme.colorScheme.secondary,
                    trackColor = MaterialTheme.colorScheme.surfaceVariant,
                    modifier = Modifier
                        .width(64.dp)
                        .align(Alignment.Center),
                )
            }
        } else if (forecasts != null) {
                if (weather != null) {
                    WeatherScreen(weather = weather, forecasts = forecasts)
                }
        }
    }
}