package com.example.capstoneproject

import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.capstoneproject.data.database.CapstoneViewModel
import com.example.capstoneproject.data.database.CapstoneViewModelFactory
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
                    val owner = LocalViewModelStoreOwner.current
                    val capstoneViewModel: CapstoneViewModel
                    owner?.let {
                        capstoneViewModel  = viewModel(
                            it,
                            "CapstoneViewModel",
                            CapstoneViewModelFactory(
                                LocalContext.current.applicationContext as Application
                            )
                        )
                        //val categoryList by capstoneViewModel.categoryList.observeAsState()
                        val restaurantList by capstoneViewModel.restaurantList.observeAsState()
                        val foodList by capstoneViewModel.foodList.observeAsState()
                        val user by capstoneViewModel.user.observeAsState()
                        val userPref by capstoneViewModel.userPrefList.observeAsState()
                        restaurantList?.let { it1 ->
                            foodList?.let { it2 ->
                                PageNavigators().Navigation(capstoneViewModel,
                                    user, userPref, it1, it2
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}