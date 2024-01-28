package com.sabadac.isimosezulu

import android.app.Application
import com.sabadac.isimosezulu.di.forecastRemoteDataSourceModule
import com.sabadac.isimosezulu.di.forecastRepositoryModule
import com.sabadac.isimosezulu.di.currentLocationUseCase
import com.sabadac.isimosezulu.di.networkModule
import com.sabadac.isimosezulu.di.weatherRemoteDataSourceModule
import com.sabadac.isimosezulu.di.weatherRepositoryModule
import com.sabadac.isimosezulu.di.weatherUseCaseModule
import com.sabadac.isimosezulu.di.weatherViewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class WeatherApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@WeatherApplication)
            modules(listOf(
                weatherViewModelModule,
                networkModule,
                forecastRepositoryModule,
                forecastRemoteDataSourceModule,
                weatherRepositoryModule,
                weatherRemoteDataSourceModule,
                weatherUseCaseModule,
                currentLocationUseCase
            ))
        }
    }
}