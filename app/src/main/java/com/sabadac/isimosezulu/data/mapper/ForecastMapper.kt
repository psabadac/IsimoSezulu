package com.sabadac.isimosezulu.data.mapper

import com.sabadac.isimosezulu.R
import com.sabadac.isimosezulu.domain.model.Forecast
import com.sabadac.isimosezulu.domain.model.Result
import com.sabadac.isimosezulu.data.model.ForecastApiModel
import java.text.SimpleDateFormat
import java.util.Locale

object ForecastMapper {

    fun mapFrom(forecastApiModel: Result<ForecastApiModel>): Result<List<Forecast>> =
        when (forecastApiModel) {
            is Result.Success -> {
                val forecastList = forecastApiModel.data.list
                if (forecastList.isEmpty()) {
                    Result.Error("Failed to find forecasts list object.")
                } else {
                    val forecasts = forecastList.map {
                        forecastDay ->
                        val weatherParam = forecastDay.weather.firstOrNull()
                        Forecast(
                            name = getNameFromUnixTimestamp(forecastDay.dt),
                            icon = imageResourceIconString(weatherParam?.icon),
                            status = weatherParam?.main ?: "",
                            temperature = forecastDay.temp.day.toInt().toString()
                        )
                    }
                    Result.Success(
                        forecasts
                    )
                }
            }

            is Result.Error -> Result.Error(forecastApiModel.message, forecastApiModel.throwable)
        }

    private fun getNameFromUnixTimestamp(unixTimestamp: Long) =
        SimpleDateFormat("EEEE", Locale.getDefault()).format(unixTimestamp * 1000)
    private fun imageResourceIconString(icon: String?) =
        when(icon) {
            "01d" -> R.drawable.weather_ic_01d
            "01n" -> R.drawable.weather_ic_01n

            "02d" -> R.drawable.weather_ic_02d
            "02n" -> R.drawable.weather_ic_02n

            "03d" -> R.drawable.weather_ic_03d
            "03n" -> R.drawable.weather_ic_03n

            "04d" -> R.drawable.weather_ic_04d
            "04n" -> R.drawable.weather_ic_04n

            "09d" -> R.drawable.weather_ic_09d
            "09n" -> R.drawable.weather_ic_09n

            "10d" -> R.drawable.weather_ic_10d
            "10n" -> R.drawable.weather_ic_10n

            "11d" -> R.drawable.weather_ic_11d
            "11n" -> R.drawable.weather_ic_11n

            "13d" -> R.drawable.weather_ic_13d
            "13n" -> R.drawable.weather_ic_13n

            "50d" -> R.drawable.weather_ic_13d
            "50n" -> R.drawable.weather_ic_13n
            else -> R.drawable.weather_ic_01d
        }
}