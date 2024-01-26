package com.sabadac.isimosezulu.di

import com.sabadac.isimosezulu.data.network.RequestInterceptor
import com.sabadac.isimosezulu.data.network.provideClient
import com.sabadac.isimosezulu.data.network.provideForecastApi
import com.sabadac.isimosezulu.data.network.provideRetrofit
import com.sabadac.isimosezulu.data.network.provideWeatherApi
import com.sabadac.isimosezulu.data.repository.ForecastRepository
import com.sabadac.isimosezulu.data.repository.WeatherRepository
import com.sabadac.isimosezulu.data.source.ForecastRemoteDataSource
import com.sabadac.isimosezulu.data.source.WeatherRemoteDataSource
import com.sabadac.isimosezulu.domain.GetWeatherUseCase
import com.sabadac.isimosezulu.ui.weather_screen.WeatherViewModel
import org.koin.dsl.module

val weatherViewModelModule = module {
    factory { WeatherViewModel(get()) }
}

val networkModule = module {
    single { RequestInterceptor() }
    single { provideClient(get()) }
    single { provideWeatherApi(get()) }
    single { provideForecastApi(get()) }
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
    factory { GetWeatherUseCase(get(), get()) }
}