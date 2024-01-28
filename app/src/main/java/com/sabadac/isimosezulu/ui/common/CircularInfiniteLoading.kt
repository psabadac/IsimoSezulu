package com.sabadac.isimosezulu.ui.common

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sabadac.isimosezulu.data.Constants

@Composable
fun CircularInfiniteLoading() {
    Box(modifier = Modifier.fillMaxSize()) {
        CircularProgressIndicator(
            color = MaterialTheme.colorScheme.secondary,
            trackColor = MaterialTheme.colorScheme.surfaceVariant,
            modifier = Modifier
                .width(64.dp)
                .align(Alignment.Center),
        )
    }
}

@Preview(
    showSystemUi = true,
    showBackground = true,
    backgroundColor = Constants.demoBackgroundColor
)
@Composable
fun CircularInfiniteLoadingPreview() {
    CircularInfiniteLoading()
}