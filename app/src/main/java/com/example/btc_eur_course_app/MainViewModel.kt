package com.example.btc_eur_course_app

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.btc_eur_course_app.datasource.MainRepository
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val repository: MainRepository
        get() = MainRepository.getInstance()


    val state: MainState = MainState()

    fun refresh() {
        viewModelScope.launch {
            state.isConnected.value = repository.testApiConnection()
            state.historicalData.value = repository.getHistoricalData().toString()
        }
    }


    companion object {
        private var instance: MainViewModel? = null

        fun getInstance(): MainViewModel {
            if (instance != null) return requireNotNull(instance)

            return MainViewModel().also {
                instance = it
            }
        }
    }
}