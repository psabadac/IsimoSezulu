package com.sabadac.isimosezulu.ui.weather_screen

import android.location.Location
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.sabadac.isimosezulu.ui.common.CircularInfiniteLoading
import com.sabadac.isimosezulu.ui.common.ErrorDialog
import com.sabadac.isimosezulu.ui.weather_screen.forecast.ForecastSection
import com.sabadac.isimosezulu.ui.weather_screen.weather.WeatherSection
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun WeatherScreen(
    location: Location,
    weatherViewModel: WeatherViewModel = koinViewModel()
) {
    val isRefreshing by remember { mutableStateOf(false) }
    val pullRefreshState = rememberPullRefreshState(
        refreshing = isRefreshing,
        onRefresh = {
            weatherViewModel.getWeather(location)
        })

    val weatherUiState by weatherViewModel.uiState.collectAsState()

    when {
        weatherUiState.isLoading -> {
            CircularInfiniteLoading()

            LaunchedEffect(Unit) {
                weatherViewModel.getWeather(location)
            }
        }

        weatherUiState.error != null -> {
            ErrorDialog(weatherUiState.error!!) {
                weatherViewModel.retry()
            }
        }

        else -> {
            Box(modifier = Modifier.pullRefresh(state = pullRefreshState)) {
                Column(modifier = Modifier
                    .background(Color(weatherUiState.weather!!.color))

                ) {
                    WeatherSection(weather = weatherUiState.weather!!, modifier = Modifier)
                    ForecastSection(forecasts = weatherUiState.forecasts!!, modifier = Modifier.fillMaxHeight())
                }
                PullRefreshIndicator(
                    refreshing = isRefreshing,
                    state = pullRefreshState,
                    modifier = Modifier.align(Alignment.TopCenter)
                )
            }
        }
    }
}