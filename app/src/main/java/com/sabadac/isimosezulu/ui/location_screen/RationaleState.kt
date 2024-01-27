package com.sabadac.isimosezulu.ui.location_screen

data class RationaleState(
    val title: String,
    val rationale: String,
    val onRationaleReply: (proceed: Boolean) -> Unit,
)