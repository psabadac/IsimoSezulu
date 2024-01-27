package com.sabadac.isimosezulu.ui.location_screen

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.sabadac.isimosezulu.R

@Composable
fun PermissionRationaleDialog(rationaleState: RationaleState) {
    AlertDialog(onDismissRequest = { rationaleState.onRationaleReply(false) }, title = {
        Text(text = rationaleState.title)
    }, text = {
        Text(text = rationaleState.rationale)
    }, confirmButton = {
        TextButton(onClick = {
            rationaleState.onRationaleReply(true)
        }) {
            Text(stringResource(R.string.continue_button))
        }
    }, dismissButton = {
        TextButton(onClick = {
            rationaleState.onRationaleReply(false)
        }) {
            Text(stringResource(R.string.dismiss_button))
        }
    })
}