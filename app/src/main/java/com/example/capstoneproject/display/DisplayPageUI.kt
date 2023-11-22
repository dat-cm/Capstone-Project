/*
This file is used to create UI for displaying "Food Subscriptions"
*/
@file:OptIn(ExperimentalMaterial3Api::class)
package com.example.capstoneproject.display

import android.annotation.SuppressLint
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
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

class DisplayPageUI {
    @OptIn(ExperimentalMaterial3Api::class)
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @Composable
    fun BuildDisplayPage(navController: NavHostController){
        Scaffold (
            topBar = {
                TopAppBar(title = { Text("Food Subscription") },
                    navigationIcon = { IconButton(onClick = {})   {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = "Close",
                            tint =  PartyPink

                        )
                    }
                                     },
                    actions = {
                        IconButton(onClick = {navController.navigate(Routes.Add.route)}) {
                            Icon(
                                imageVector = Icons.Default.Add,
                                contentDescription = "Add",
                                tint = PartyPink
                            )
                        }
                    }
                    )
            }
        ){//to do list view from firebase
         }
    }
}