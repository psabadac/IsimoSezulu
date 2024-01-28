package com.sabadac.isimosezulu.domain

import android.location.Location
import com.sabadac.isimosezulu.data.repository.ForecastRepository
import com.sabadac.isimosezulu.data.repository.WeatherRepository
import com.sabadac.isimosezulu.domain.model.Forecast
import com.sabadac.isimosezulu.domain.model.WeatherUiState
import kotlinx.coroutines.withContext
import com.sabadac.isimosezulu.domain.model.Result
import com.sabadac.isimosezulu.domain.model.Weather
import kotlin.coroutines.CoroutineContext

class GetWeatherUseCase(
    private val weatherRepository: WeatherRepository,
    private val forecastRepository: ForecastRepository,
    private val dispatcher: CoroutineContext
) {
    suspend operator fun invoke(location: Location): Result<WeatherUiState> =
        withContext(dispatcher) {
            val weather = weatherRepository.getWeather(location = location)
            val forecasts = forecastRepository.getForecast(location = location)

            when {
                weather is Result.Error -> {
                    Result.Error(weather.message, weather.throwable)
                }
                forecasts is Result.Error -> {
                    Result.Error(forecasts.message, forecasts.throwable)
                }
                else -> {
                    Result.Success(
                        WeatherUiState(
                            weather = (weather as Result.Success<Weather>).data,
                            forecasts = (forecasts as Result.Success<List<Forecast>>).data,
                            error = null,
                            isLoading = false
                        )
                    )
                }
            }
        }
}