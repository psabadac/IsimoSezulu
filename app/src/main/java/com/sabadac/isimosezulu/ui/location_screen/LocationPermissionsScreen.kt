package com.sabadac.isimosezulu.ui.location_screen

import android.Manifest
import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import com.google.accompanist.permissions.shouldShowRationale
import com.sabadac.isimosezulu.R

@SuppressLint("MissingPermission")
@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun LocationPermissionsScreen() {
    val locationPermissionState = rememberPermissionState(
        Manifest.permission.ACCESS_COARSE_LOCATION,
    )

    var rationaleState by remember {
        mutableStateOf<RationaleState?>(null)
    }

    rationaleState?.run { PermissionRationaleDialog(rationaleState = this) }

    if (locationPermissionState.status.isGranted) {
        CurrentLocationScreen()
    } else if (locationPermissionState.status.shouldShowRationale) {
        rationaleState = RationaleState(
            stringResource(R.string.request_approximate_location_access),
            stringResource(R.string.request_approximate_location_access_description),
        ) { proceed ->
            if (proceed) {
                locationPermissionState.launchPermissionRequest()
            }
            rationaleState = null
        }
    } else {
        Box(modifier = Modifier.fillMaxSize()) {
            Button(onClick = {
                locationPermissionState.launchPermissionRequest()
            }, modifier = Modifier.align(Alignment.Center)) {
                Text(text = stringResource(R.string.request_location_permission))
            }
        }
    }
}