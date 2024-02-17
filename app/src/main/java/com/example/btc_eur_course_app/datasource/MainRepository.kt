package com.example.btc_eur_course_app.datasource

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainRepository {
    private val baseUrl: String = "https://api.coingecko.com/api/v3/"


    private val retrofitClient by lazy {
        Retrofit.Builder()
            .baseUrl(baseUrl)
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
