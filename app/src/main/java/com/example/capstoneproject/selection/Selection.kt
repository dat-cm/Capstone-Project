/*
This file is used to create UI for displaying "Food Subscriptions"
*/
@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.capstoneproject.selection

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.capstoneproject.data.createFoodProfiles
import com.example.capstoneproject.data.database.CapstoneViewModel
import com.example.capstoneproject.data.database.food.Food
import com.example.capstoneproject.data.database.restaurant.Restaurant
import com.example.capstoneproject.data.database.user.User
import com.example.capstoneproject.data.database.userfavourite.UserFavourite
import com.example.capstoneproject.data.database.userpreferences.UserPreferences
import com.example.capstoneproject.navigator.Routes
import com.example.capstoneproject.selection.swipeables.SwipeCard
import com.example.capstoneproject.ui.theme.PartyPink

@RequiresApi(Build.VERSION_CODES.N)
@Suppress("ktlint:standard:function-naming")
@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SelectionUI(
    navController: NavHostController,
    capstoneViewModel: CapstoneViewModel,
    user: User?,
    userPref: UserPreferences?,
    restaurantList: List<Restaurant?>,
    foodList: List<Food?>,
    userFav: List<UserFavourite?>,
) {
    Scaffold(
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
                            },
                        ) {
                            Icon(
                                imageVector = Icons.Default.Close,
                                contentDescription = "Close",
                                tint = PartyPink,
                            )
                        }
                    },
                    actions = {
                        IconButton(
                            onClick = {
                                navController.navigate(Routes.Like.route)
                            },
                        ) {
                            Icon(
                                imageVector = Icons.Default.Favorite,
                                contentDescription = "like",
                                tint = PartyPink,
                            )
                        }
                        IconButton(
                            onClick = {
                                navController.navigate(Routes.Preferences.route)
                            },
                        ) {
                            Icon(
                                imageVector = Icons.Default.Settings,
                                contentDescription = "preference",
                                tint = PartyPink,
                            )
                        }
                    },
                )
            }
        },
    ) {
            paddingValues ->
        createFoodProfiles(userPref, restaurantList, foodList, userFav)
        SwipeCard(capstoneViewModel, user, navController, paddingValues)
    }
}
