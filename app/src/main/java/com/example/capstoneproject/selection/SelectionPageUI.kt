/*
This file is used to create UI for displaying "Food Subscriptions"
*/
@file:OptIn(ExperimentalMaterial3Api::class)
package com.example.capstoneproject.selection

import android.annotation.SuppressLint
import androidx.browser.trusted.ScreenOrientation
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.materialIcon
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.room.util.getColumnIndex
import com.example.capstoneproject.navigator.Routes
import com.example.capstoneproject.swipeables.SwipeCards
import com.example.capstoneproject.ui.theme.PartyPink
import com.google.common.collect.Multimaps.index
import org.checkerframework.common.subtyping.qual.Bottom

class SelectionPageUI {
    @OptIn(ExperimentalMaterial3Api::class)
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @Composable
    fun BuildSelectionPage(navController: NavHostController){
        val screen = listOf("Selection", "Like")
        var currentScreen by remember { mutableStateOf(screen.first()) }
        var selectedScreen by remember { mutableStateOf(false)}
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
            }){
                SwipeCards()}
         }
    }