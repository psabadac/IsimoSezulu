package com.sabadac.isimosezulu.data.network

import com.sabadac.isimosezulu.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class RequestInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val initialRequest = chain.request()

        val url = initialRequest.url()
            .newBuilder()
            .addQueryParameter("appid", BuildConfig.API_KEY)
            .addQueryParameter("units", "metric")
            .build()

        val request = initialRequest.newBuilder()
            .url(url)
            .build()
        return chain.proceed(request)
    }
}