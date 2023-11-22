package com.example.capstoneproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.capstoneproject.display.DisplayPageUI
import com.example.capstoneproject.navigator.PageNavigators
import com.example.capstoneproject.ui.theme.CapstoneProjectTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CapstoneProjectTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                    PageNavigators().Navigation()
                }
            }
        }
    }
}

class DisplaySubscriptionPage(
    subscriptionName: String,
    subscriptionDay: String,
    subscriptionTime: String,
    playSubscription: Boolean

) {
    //variables used for displaying all contents on subscription page
    var mSubscriptionName: String = subscriptionName
    var mSubscriptionDay: String = subscriptionDay
    var mSubscriptionTime: String = subscriptionTime
    var mPlaySubscription: Boolean = playSubscription

}