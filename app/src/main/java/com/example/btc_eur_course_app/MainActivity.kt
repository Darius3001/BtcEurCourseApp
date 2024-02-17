package com.example.btc_eur_course_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import com.example.btc_eur_course_app.ui.theme.BtcEurCourseAppTheme

class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel
        get() = MainViewModel.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BtcEurCourseAppTheme {
                Column(
                    modifier = Modifier.fillMaxSize()
                ) {

                    Button(onClick = { viewModel.refresh() }) {
                        Text(text = "Ping")
                    }

                    val text = if (viewModel.state.isConnected.value) "successfully connected"
                    else "could not ping"

                    Text(text = text)

                }
            }
        }
    }
}
