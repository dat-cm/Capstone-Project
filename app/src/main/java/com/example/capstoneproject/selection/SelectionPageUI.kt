/*
This file is used to create UI for displaying "Food Subscriptions"
*/
@file:OptIn(ExperimentalMaterial3Api::class)
package com.example.capstoneproject.selection

import android.annotation.SuppressLint
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.capstoneproject.navigator.Routes
import com.example.capstoneproject.swipeables.SwipeCards
import com.example.capstoneproject.ui.theme.PartyPink

class SelectionPageUI {
    @OptIn(ExperimentalMaterial3Api::class)
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @Composable
    fun BuildSelectionPage(navController: NavHostController){
        Scaffold (
            topBar = {
                Surface(
                    shadowElevation = 2.dp,
                ) {
                    TopAppBar(
                        title = { Text("Food Subscription") },
                        navigationIcon = {
                            IconButton(
                                onClick = {
                                    navController.navigate(Routes.Home.route)
                                })   {
                                Icon(
                                    imageVector = Icons.Default.Close,
                                    contentDescription = "Close",
                                    tint =  PartyPink
                                )
                            }
                        },
                        actions = {
                            IconButton(
                                onClick = {
                                    navController.navigate(Routes.Preferences.route)}) {
                                Icon(
                                    imageVector = Icons.Default.Settings,
                                    contentDescription = "preference",
                                    tint = PartyPink
                                )
                            }
                        }
                    )
                }
            },
        ){
        //to do list view from firebase
            SwipeCards()
         }
    }

}