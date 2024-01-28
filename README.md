# IsimoSezulu
Another Android Weather App

![demo animation](untitled.gif)

## Libraries used
 - [x] `androidx.compose.material3:material3-android:1.2.0-rc01` for material design and to prevent crashes in `CircularProgressIndicator`
 - [x] `androidx.compose.material:material:1.6.0` for pull to refresh
 - [x] `androidx.lifecycle:lifecycle-viewmodel-compose:2.7.0` for compose lifecycler
 - [x] `io.insert-koin:koin-androidx-compose:3.6.0-wasm-alpha1` for dependency injection
 - [x] `com.squareup.retrofit2:retrofit:2.9.0` and `com.squareup.retrofit2:converter-gson:2.9.0` for networking
 - [x] `com.google.android.gms:play-services-location:21.1.0` and `org.jetbrains.kotlinx:kotlinx-coroutines-play-services:1.7.3` and `com.google.accompanist:accompanist-permissions:0.34.0` for location
 - [x] `io.mockk:mockk:1.13.9` for unit tests
 - [x] `app.cash.paparazzi` plugin version `1.3.2` for Paparazzi Ui tests

## Paparazzi workaround to fix crashes
```
dependencies.constraints {
    testImplementation("com.google.guava:guava") {
        attributes {
            attribute(
                TargetJvmEnvironment.TARGET_JVM_ENVIRONMENT_ATTRIBUTE,
                objects.named(TargetJvmEnvironment::class.java, TargetJvmEnvironment.STANDARD_JVM)
            )
        }
        because("Paparazzi's layoutlib and sdk-common depend on Guava's -jre published variant." +
                "See https://github.com/cashapp/paparazzi/issues/906.")
    }
}
```

## How to build
- [x] Please set `api_key="YOUR_API_KEY"` in `gradle.properties` file

## Architecture
- [x] I've tried to stick to Ui-Domain-Data approach, but I used less interfaces than I shoud have.
- [x] In the Ui I've only put composables and the related viewModels (one viewModel per screen approach)
- [x] The Ui flow is: `LocationScreen` -> `WeatherScreen`.
- [x] For each network request I use `RequestInterceptor` to add the `appid` parameter - which is the `api_key` you've set above 
- [x] The data flow for `LocationScreen` is: `LocationScreen` -> `LocationViewModel` -> `LocationUseCase`
- [x] The data flow for `WeatherScreen` is `WeatherViewModel` -> `WeatherUseCase` -> `WeatherRepository` & `ForecastRepository`
- [x] `WeatherRepository` calls `WeatherRemoteDataSource` which calls the `WeatherApi` to retrieve the data
- [x] `WeatherRepository` uses `WeatherMapper` to convert the data received into a more suitable format
- [x] `ForecastRepository` calls `ForecastRemoteDataSource` which calls the ForecastApi to retrieve the data
- [x] `ForecastRepository` uses `ForecastMapper` to convert the data received in a more suitable format
