package com.example.btc_eur_course_app.datasource.network.model

import com.google.gson.annotations.SerializedName

data class PingResponse(
    @SerializedName("gecko_says")
    val geckoSays: String
)
