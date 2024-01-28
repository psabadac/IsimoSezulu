package com.sabadac.isimosezulu.ui.common

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.sabadac.isimosezulu.R

@Composable
fun ErrorDialog(
    message: String,
    retry: () -> Unit
) {
    Box(modifier = Modifier.fillMaxSize()) {
        AlertDialog(
            onDismissRequest = {},
            title = {
                Text(text = stringResource(R.string.an_error_has_occurred))
            },
            text = {
                Text(text = message)
            },
            confirmButton = {
                Button(
                    onClick = retry
                ) {
                    Text(text = stringResource(R.string.retry))
                }
            }
        )
    }
}