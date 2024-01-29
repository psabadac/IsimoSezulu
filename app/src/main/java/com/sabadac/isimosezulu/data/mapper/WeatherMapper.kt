package com.sabadac.isimosezulu.data.mapper

import com.sabadac.isimosezulu.R
import com.sabadac.isimosezulu.data.Constants.cloudyRange
import com.sabadac.isimosezulu.data.Constants.rainyRange
import com.sabadac.isimosezulu.domain.model.Result
import com.sabadac.isimosezulu.domain.model.Weather
import com.sabadac.isimosezulu.data.model.WeatherApiModel

object WeatherMapper {
    fun mapFrom(weatherApiModel: Result<WeatherApiModel>): Result<Weather> =
        when (weatherApiModel) {
            is Result.Success -> {
                val weather = weatherApiModel.data.weather.firstOrNull()
                if (weather == null) {
                    Result.Error("Failed to find weather object.")
                } else {
                    Result.Success(
                        Weather(
                            image = imageResourceIdFromCode(weather.id),
                            color = colorFromWeatherId(weather.id),
                            status = weather.main,
                            min = weatherApiModel.data.main.tempMin.toInt().toString(),
                            current = weatherApiModel.data.main.temp.toInt().toString(),
                            max = weatherApiModel.data.main.tempMax.toInt().toString()
                        )
                    )
                }
            }

            is Result.Error -> Result.Error(weatherApiModel.message, weatherApiModel.throwable)
        }

    private fun imageResourceIdFromCode(code: Int) = when (code) {
        in cloudyRange -> R.drawable.forest_cloudy
        in rainyRange -> R.drawable.forest_rainy
        else -> R.drawable.forest_sunny
    }

    private fun colorFromWeatherId(code: Int) =
        when (code) {
            in cloudyRange -> R.color.cloudy
            in rainyRange -> R.color.rainy
            else -> R.color.sunny
        }
}