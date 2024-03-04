package com.example.btc_eur_course_app.datasource.network

import com.example.btc_eur_course_app.datasource.network.model.HistoricalBitcoinDataResponse
import com.example.btc_eur_course_app.datasource.network.model.PingResponse
import retrofit2.Response
import retrofit2.http.GET


interface CoinGeckoApi {
    @GET("ping")
    suspend fun ping(): Response<PingResponse>

    @GET("coins/bitcoin/market_chart?vs_currency=eur&days=14&interval=daily")
    suspend fun getHistoricalBitcoinData(): Response<HistoricalBitcoinDataResponse>
}