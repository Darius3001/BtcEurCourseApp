package com.example.btc_eur_course_app.datasource.network

import com.example.btc_eur_course_app.datasource.PingResponse
import retrofit2.Response
import retrofit2.http.GET


interface CoinGeckoApi {
    @GET("ping")
    suspend fun ping(): Response<PingResponse>
}