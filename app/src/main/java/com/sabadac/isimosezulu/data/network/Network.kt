package com.sabadac.isimosezulu.data.network

import com.sabadac.isimosezulu.BuildConfig
import com.sabadac.isimosezulu.data.api.ForecastApi
import com.sabadac.isimosezulu.data.api.WeatherApi
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

fun provideRetrofit(client: OkHttpClient): Retrofit =
     Retrofit.Builder()
         .baseUrl(BuildConfig.BASE_URL)
         .client(client)
         .addConverterFactory(GsonConverterFactory.create())
         .build()

fun provideClient(interceptor: RequestInterceptor) =
    OkHttpClient().newBuilder().addInterceptor(interceptor).build()

fun provideWeatherApi(retrofit: Retrofit): WeatherApi =
    retrofit.create(WeatherApi::class.java)

fun provideForecastApi(retrofit: Retrofit): ForecastApi =
    retrofit.create(ForecastApi::class.java)