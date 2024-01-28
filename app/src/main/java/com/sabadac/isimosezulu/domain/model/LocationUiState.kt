package com.sabadac.isimosezulu.domain.model

import android.location.Location

data class LocationUiState(
    val location: Location?,
    val error: String?,
    val isLoading: Boolean = true,
)
