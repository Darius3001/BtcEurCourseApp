package com.example.btc_eur_course_app.datasource.network.model

import com.example.btc_eur_course_app.BuildConfig
import com.google.gson.annotations.SerializedName

data class PingResponse(
    @SerializedName("gecko_says?x_cg_demo_api_key=${BuildConfig.API_KEY}")
    val geckoSays: String
)
