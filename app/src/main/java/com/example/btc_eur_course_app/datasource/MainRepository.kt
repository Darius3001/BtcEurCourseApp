package com.example.btc_eur_course_app.datasource

import android.util.Log
import com.example.btc_eur_course_app.datasource.domain.BitcoinData
import com.example.btc_eur_course_app.datasource.network.CoinGeckoApi
import com.example.btc_eur_course_app.datasource.network.interceptor.CoinGeckoAuthInterceptor
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainRepository {
    private val baseUrl: String = "https://api.coingecko.com/api/v3/"

    private val okHttpClient: OkHttpClient by lazy {
        OkHttpClient.Builder()
            .addInterceptor(CoinGeckoAuthInterceptor())
            .build()
    }

    private val retrofitClient by lazy {
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private val api by lazy {
        retrofitClient.create(CoinGeckoApi::class.java)
    }

    suspend fun testApiConnection(): Boolean = withContext(Dispatchers.IO) {
        try {

            val response = api.ping()
            Log.i("ping", response.toString())
            true
        } catch (e: Exception) {
            Log.i("ping", "$e")
            false
        }
    }

    suspend fun getHistoricalData(): List<BitcoinData> = withContext(Dispatchers.IO) {
        try {

            val responseBody = api.getHistoricalBitcoinData().body()

            if (responseBody == null) {
                Log.w("Historical data", "api call was not successful")
                return@withContext emptyList()
            }

            responseBody.prices.map {
                val timestamp = it[0].toLong()
                val value = it[1].toDouble()

                BitcoinData(timestamp, value)
            }
        } catch (e: Exception) {
            Log.w("Historical data", "$e")
            emptyList()
        }
    }

    companion object {
        private var instance: MainRepository? = null

        fun getInstance(): MainRepository {
            if (instance != null) return requireNotNull(instance)

            return MainRepository().also {
                instance = it
            }
        }
    }
}
