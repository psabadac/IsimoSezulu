package com.sabadac.isimosezulu.ui.common

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.sabadac.isimosezulu.R
import com.sabadac.isimosezulu.data.Constants

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

@Preview(
    showSystemUi = true,
    showBackground = true,
    backgroundColor = Constants.demoBackgroundColor
)
@Composable
fun ErrorDialogPreview() {
    ErrorDialog(message = "THis is a terrible error") {
        
    }
}