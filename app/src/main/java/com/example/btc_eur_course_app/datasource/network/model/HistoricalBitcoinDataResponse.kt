package com.example.btc_eur_course_app.datasource.network.model

import com.google.gson.annotations.SerializedName

data class HistoricalBitcoinDataResponse(
    @SerializedName("prices")
    val prices: List<List<String>>
)
