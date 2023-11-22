package com.example.capstoneproject


import android.annotation.SuppressLint
import android.os.Bundle
import android.provider.CalendarContract.Colors
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.unit.dp
import com.example.capstoneproject.ui.theme.CapstoneProjectTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CapstoneProjectTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(R.color.white)
                ) {
                    Scaffold (
                        topBar = {
                            SmallTopAppBar(title = { Text("Food Subscription") },
                                navigationIcon = { IconButton(onClick = {})   {
                                    Icon(
                                        imageVector = Icons.Default.Close,
                                        contentDescription = "Close",
                                        tint =  Color(255,43,133)

                                       )

                                }
                                },
                                actions = {IconButton(onClick = {}) {
                                    Icon(
                                        imageVector =  Icons.Default.Add,
                                        contentDescription = "Add",
                                        tint =  Color(255,43,133))
                                }
                                },

                                )
                        }
                    ){}
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