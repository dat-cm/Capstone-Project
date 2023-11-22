/*
This file is used to create UI for "Create Subscriptions"
*/
package com.example.capstoneproject.add

import android.annotation.SuppressLint
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.capstoneproject.navigator.Routes
import com.example.capstoneproject.ui.theme.PartyPink

class AddPageUI {
    @OptIn(ExperimentalMaterial3Api::class)
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @Composable
    fun BuildAddPage(navController: NavHostController){
        Scaffold (
            topBar = {
                TopAppBar(title = { Text("Create Subscription") },
                    navigationIcon = { IconButton(onClick = {navController.navigate(
                        Routes.Display.route
                    )})   {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = "Close",
                            tint =  PartyPink

                        )
                    }
                    }
                )
            }
        ){//to do list view from firebase
        }
    }
}