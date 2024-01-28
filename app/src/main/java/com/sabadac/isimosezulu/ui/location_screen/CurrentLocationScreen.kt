package com.sabadac.isimosezulu.ui.location_screen

import android.Manifest
import androidx.annotation.RequiresPermission
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
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
    val weatherUiState by weatherViewModel.uiState.collectAsState()

    val context = LocalContext.current
    val locationClient = remember {
        LocationServices.getFusedLocationProviderClient(context)
    }

    if (weatherUiState.isLoading) {
        CircularInfiniteLoading()

        LaunchedEffect(Unit) {
            withContext(Dispatchers.IO) {
                val location = locationClient.getCurrentLocation(
                    Priority.PRIORITY_BALANCED_POWER_ACCURACY,
                    CancellationTokenSource().token
                ).await()

                weatherViewModel.getWeather(location)
            }
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