package com.sabadac.isimosezulu.data

import com.sabadac.isimosezulu.R
import com.sabadac.isimosezulu.domain.model.Forecast
import com.sabadac.isimosezulu.domain.model.Weather

object Constants {
    const val demoBackgroundColor = 0x54717AL

    val cloudyRange = 801..804
    val rainyRange = 200..600

    val demoWeather = Weather(
        image = R.drawable.forest_cloudy,
        color = R.color.cloudy,
        status = "CLOUDY",
        min = "18",
        current = "24",
        max = "26"
    )

    val demoForecast = Forecast(
        name = "Monday",
        icon = R.drawable.weather_ic_01d,
        status = "Snow",
        temperature = "19"
    )

    val demoForecasts = listOf(
        Forecast(
            name = "Monday",
            icon = R.drawable.weather_ic_01d,
            status = "Snow",
            temperature = "19"
        ),
        Forecast(
            name = "Tuesday",
            icon = R.drawable.weather_ic_02d,
            status = "Snow",
            temperature = "18"
        ),
        Forecast(
            name = "Wednesday",
            icon = R.drawable.weather_ic_03d,
            status = "Snow",
            temperature = "15"
        ),
        Forecast(
            name = "Thursday",
            icon = R.drawable.weather_ic_04d,
            status = "Snow",
            temperature = "17"
        ),
        Forecast(
            name = "Friday",
            icon = R.drawable.weather_ic_09d,
            status = "Snow",
            temperature = "19"
        )
    )
}