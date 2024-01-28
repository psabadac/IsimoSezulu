package com.sabadac.isimosezulu.ui.weather_screen

import android.annotation.SuppressLint
import android.location.Location
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sabadac.isimosezulu.domain.GetWeatherUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import com.sabadac.isimosezulu.domain.model.Result
import com.sabadac.isimosezulu.domain.model.WeatherUiState
import kotlinx.coroutines.flow.update

class WeatherViewModel(
    private val getWeatherUseCase: GetWeatherUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(
        WeatherUiState(
            weather = null,
            forecasts = null,
            error = null,
            isLoading = true
        )
    )
    val uiState: StateFlow<WeatherUiState> = _uiState.asStateFlow()

    @SuppressLint("MissingPermission")
    fun getWeather(location: Location) {
        viewModelScope.launch {
            when (val weatherUiState = getWeatherUseCase.invoke(location)) {
                is Result.Success -> {
                    _uiState.value = weatherUiState.data
                }

                is Result.Error -> {
                    handleError(errorMessage = weatherUiState.message)
                }
            }
        }
    }

    fun retry() {
        _uiState.update { currentState ->
            currentState.copy(isLoading = true)
        }
    }

    private fun handleError(errorMessage: String) {
        _uiState.value = WeatherUiState(
            weather = null,
            forecasts = null,
            isLoading = false,
            error = errorMessage
        )
    }
}