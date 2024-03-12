package com.example.btc_eur_course_app

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.example.btc_eur_course_app.datasource.domain.BitcoinData

data class MainState(
    val isConnected: MutableState<Boolean> = mutableStateOf(false),
    val historicalData: MutableState<List<BitcoinData>> = mutableStateOf(listOf())
)
