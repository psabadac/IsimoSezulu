package com.sabadac.isimosezulu.ui.location_screen

import android.location.Location

data class LocationUiState(
    val location: Location?,
    val error: String?,
    val isLoading: Boolean = true,
)
