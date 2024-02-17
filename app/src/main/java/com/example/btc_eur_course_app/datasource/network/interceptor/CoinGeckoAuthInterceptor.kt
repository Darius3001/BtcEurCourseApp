package com.example.btc_eur_course_app.datasource.network.interceptor

import com.example.btc_eur_course_app.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class CoinGeckoAuthInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .url(
                chain.request().url.newBuilder()
                    .addQueryParameter("x_cg_demo_api_key", BuildConfig.API_KEY)
                    .build()
            )
            .build()

        return chain.proceed(request)
    }
}