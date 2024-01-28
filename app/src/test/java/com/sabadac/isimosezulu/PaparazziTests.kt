package com.sabadac.isimosezulu

import android.location.Location
import androidx.compose.ui.Modifier
import app.cash.paparazzi.DeviceConfig
import app.cash.paparazzi.Paparazzi
import com.sabadac.isimosezulu.domain.model.Forecast
import com.sabadac.isimosezulu.domain.model.Weather
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
    private val weather = Weather(
        image = R.drawable.forest_cloudy,
        color = R.color.cloudy,
        status = "CLOUDY",
        min = "18",
        current = "24",
        max = "26"
    )

    private val forecast = Forecast(
        name = "Monday",
        icon = R.drawable.weather_ic_01d,
        status = "Snow",
        temperature = "19"
    )

    private val forecasts = listOf(
        Forecast(
            name = "Monday",
            icon = R.drawable.weather_ic_01d,
            status = "Snow",
            temperature = "19"
        ),
        Forecast(
            name = "Tuesday",
            icon = R.drawable.weather_ic_02d,
            status = "Snow",
            temperature = "18"
        ),
        Forecast(
            name = "Wednesday",
            icon = R.drawable.weather_ic_03d,
            status = "Snow",
            temperature = "15"
        ),
        Forecast(
            name = "Thursday",
            icon = R.drawable.weather_ic_04d,
            status = "Snow",
            temperature = "17"
        ),
        Forecast(
            name = "Friday",
            icon = R.drawable.weather_ic_09d,
            status = "Snow",
            temperature = "19"
        )
    )

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
            WeatherField(weather = weather, modifier = Modifier)
        }
    }

    @Test
    fun weatherRowTest() {
        paparazzi.snapshot {
            WeatherRow(weather = weather, modifier = Modifier)
        }
    }

    @Test
    fun forecastRowTest() {
        paparazzi.snapshot {
            ForecastRow(forecast = forecast, modifier = Modifier)
        }
    }

    @Test
    fun weatherSectionTest() {
        paparazzi.snapshot {
            WeatherSection(weather = weather, modifier = Modifier)
        }
    }

    @Test
    fun forecastSectionTest() {
        paparazzi.snapshot {
            ForecastSection(forecasts = forecasts, modifier = Modifier)
        }
    }

    @Test
    fun weatherScreenTest() {
        paparazzi.snapshot {
            val uiState = MutableStateFlow(
                WeatherUiState(
                    weather = weather,
                    forecasts = forecasts,
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