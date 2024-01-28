package com.sabadac.isimosezulu.domain

import android.location.Location
import com.sabadac.isimosezulu.data.repository.ForecastRepository
import com.sabadac.isimosezulu.data.repository.WeatherRepository
import com.sabadac.isimosezulu.domain.model.WeatherUiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import com.sabadac.isimosezulu.domain.model.Result

class GetWeatherUseCase(
    private val weatherRepository: WeatherRepository,
    private val forecastRepository: ForecastRepository,
) {
    suspend operator fun invoke(location: Location): Result<WeatherUiState> =
        withContext(Dispatchers.IO) {
            val weather = weatherRepository.getWeather(location = location)
            val forecasts = forecastRepository.getForecast(location = location)

            if (weather is Result.Success && forecasts is Result.Success) {
                Result.Success(
                    WeatherUiState(
                        weather = weather.data,
                        forecasts = forecasts.data,
                        error = null,
                        isLoading = false
                    )
                )
            } else if (weather is Result.Error) {
                Result.Error(weather.message, weather.throwable)
            } else {
                val error = forecasts as Result.Error
                Result.Error(error.message, error.throwable)
            }
        }
}