package com.sabadac.isimosezulu.di

import android.content.Context
import com.google.android.gms.location.LocationServices
import com.sabadac.isimosezulu.BuildConfig
import com.sabadac.isimosezulu.data.api.ForecastApi
import com.sabadac.isimosezulu.data.api.WeatherApi
import com.sabadac.isimosezulu.data.network.RequestInterceptor
import com.sabadac.isimosezulu.data.repository.ForecastRepository
import com.sabadac.isimosezulu.data.repository.WeatherRepository
import com.sabadac.isimosezulu.data.source.ForecastRemoteDataSource
import com.sabadac.isimosezulu.data.source.WeatherRemoteDataSource
import com.sabadac.isimosezulu.domain.GetCurrentLocationUseCase
import com.sabadac.isimosezulu.domain.GetWeatherUseCase
import com.sabadac.isimosezulu.ui.location_screen.LocationViewModel
import com.sabadac.isimosezulu.ui.weather_screen.WeatherViewModel
import kotlinx.coroutines.Dispatchers
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val weatherViewModelModule = module {
    factory { WeatherViewModel(get()) }
}

val locationViewModelModule = module {
    factory { LocationViewModel(get()) }
}

val networkModule = module {
    factory { RequestInterceptor() }
    factory { provideClient(get()) }
    factory { provideWeatherApi(get()) }
    factory { provideForecastApi(get()) }
    single { provideRetrofit(get()) }
}

val forecastRepositoryModule = module {
    factory { ForecastRepository(get()) }
}

val forecastRemoteDataSourceModule = module {
    factory { ForecastRemoteDataSource(get()) }
}

val weatherRepositoryModule = module {
    factory { WeatherRepository(get()) }
}

val weatherRemoteDataSourceModule = module {
    factory { WeatherRemoteDataSource(get()) }
}

val weatherUseCaseModule = module {
    factory { GetWeatherUseCase(get(), get(), provideIoDispatcher()) }
}

val currentLocationUseCase = module {
    factory { GetCurrentLocationUseCase(provideLocationClient(get()), provideIoDispatcher()) }
}

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

fun provideIoDispatcher() = Dispatchers.IO
fun provideLocationClient(context: Context) = LocationServices.getFusedLocationProviderClient(context)