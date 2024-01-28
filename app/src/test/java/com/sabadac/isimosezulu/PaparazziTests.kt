package com.sabadac.isimosezulu

import android.location.Location
import androidx.compose.ui.Modifier
import app.cash.paparazzi.DeviceConfig
import app.cash.paparazzi.Paparazzi
import com.sabadac.isimosezulu.data.Constants.demoForecast
import com.sabadac.isimosezulu.data.Constants.demoForecasts
import com.sabadac.isimosezulu.data.Constants.demoWeather
import com.sabadac.isimosezulu.domain.model.WeatherUiState
import com.sabadac.isimosezulu.ui.common.CircularInfiniteLoading
import com.sabadac.isimosezulu.ui.weather_screen.WeatherScreen
import com.sabadac.isimosezulu.ui.weather_screen.WeatherViewModel
import com.sabadac.isimosezulu.ui.weather_screen.forecast.ForecastRow
import com.sabadac.isimosezulu.ui.weather_screen.forecast.ForecastSection
import com.sabadac.isimosezulu.ui.weather_screen.weather.WeatherField
import com.sabadac.isimosezulu.ui.weather_screen.weather.WeatherRow
import com.sabadac.isimosezulu.ui.weather_screen.weather.WeatherSection
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import org.junit.Rule
import org.junit.Test

class PaparazziTests {

    @get:Rule
    val paparazzi = Paparazzi(
        deviceConfig = DeviceConfig.PIXEL_5
    )

    @Test
    fun circularInfiniteLoadingTest() {
        paparazzi.snapshot {
            CircularInfiniteLoading()
        }
    }

    @Test
    fun weatherFieldTest() {
        paparazzi.snapshot {
            WeatherField(weather = demoWeather, modifier = Modifier)
        }
    }

    @Test
    fun weatherRowTest() {
        paparazzi.snapshot {
            WeatherRow(weather = demoWeather, modifier = Modifier)
        }
    }

    @Test
    fun forecastRowTest() {
        paparazzi.snapshot {
            ForecastRow(forecast = demoForecast, modifier = Modifier)
        }
    }

    @Test
    fun weatherSectionTest() {
        paparazzi.snapshot {
            WeatherSection(weather = demoWeather, modifier = Modifier)
        }
    }

    @Test
    fun forecastSectionTest() {
        paparazzi.snapshot {
            ForecastSection(forecasts = demoForecasts, modifier = Modifier)
        }
    }

    @Test
    fun weatherScreenTest() {
        paparazzi.snapshot {
            val uiState = MutableStateFlow(
                WeatherUiState(
                    weather = demoWeather,
                    forecasts = demoForecasts,
                    error = null,
                    isLoading = false
                )
            )
           val viewModel = mockk<WeatherViewModel>()
           every { viewModel.uiState } returns uiState as StateFlow<WeatherUiState>

            WeatherScreen(location = Location(""), weatherViewModel = viewModel)
        }
    }
}