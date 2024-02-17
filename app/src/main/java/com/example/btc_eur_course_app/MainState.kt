package com.example.btc_eur_course_app

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

data class MainState(
    val isConnected: MutableState<Boolean> = mutableStateOf(false),
)
