package com.sabadac.isimosezulu.ui.location_screen

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sabadac.isimosezulu.domain.GetCurrentLocationUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LocationViewModel(
    private val getCurrentLocationUseCase: GetCurrentLocationUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(
        LocationUiState(
            location = null,
            error = null,
            isLoading = true
        )
    )

    val uiState: StateFlow<LocationUiState> = _uiState.asStateFlow()

    @SuppressLint("MissingPermission")
    fun getLocation() {
        viewModelScope.launch {
            val location = this@LocationViewModel.getCurrentLocationUseCase.invoke()
            if (location == null) {
                handleNullLocation()
                return@launch
            }
            _uiState.value = LocationUiState(
                location = location,
                error = null,
                isLoading = false
            )
        }
    }

    private fun handleNullLocation() {
        _uiState.update { currentState ->
            currentState.copy(
                isLoading = false,
                error = "Error Getting location."
            )
        }
    }

}