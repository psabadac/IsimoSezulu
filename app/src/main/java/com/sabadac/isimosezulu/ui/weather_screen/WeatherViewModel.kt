package com.sabadac.isimosezulu.ui.weather_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sabadac.isimosezulu.domain.GetWeatherUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import com.sabadac.isimosezulu.domain.model.Result
import com.sabadac.isimosezulu.domain.model.WeatherUiState

class WeatherViewModel(
    private val getWeatherUseCase: GetWeatherUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(
        WeatherUiState(
            weather = null,
            forecasts = null
        )
    )
    val uiState: StateFlow<WeatherUiState> = _uiState.asStateFlow()

    fun getWeather(lat: Double, lon: Double) {
        viewModelScope.launch {
            when (val weatherUiState = getWeatherUseCase.invoke(lat, lon)) {
                is Result.Success -> {
                    _uiState.value = weatherUiState.data
                }
                is Result.Error -> {
                    println(weatherUiState.message)
                    println(weatherUiState.throwable)
                }
            }
        }
    }
}