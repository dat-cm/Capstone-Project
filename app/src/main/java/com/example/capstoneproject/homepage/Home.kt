package com.example.capstoneproject.homepage

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.capstoneproject.data.database.food.Food
import com.example.capstoneproject.data.database.restaurant.Restaurant
import com.example.capstoneproject.data.database.user.User
import com.example.capstoneproject.data.database.userpreferences.UserPreferences
import com.example.capstoneproject.homepage.drawer.DrawerBody
import com.example.capstoneproject.homepage.drawer.DrawerHeader
import com.example.capstoneproject.homepage.focustext.FocusTextField
import com.example.capstoneproject.homepage.topbar.TopBar
import com.example.capstoneproject.ui.theme.CoolGrey

@Suppress("ktlint:standard:function-naming")
@Composable
fun HomeUI(
    navController: NavHostController,
    user: User?,
    userPref: UserPreferences?,
    restaurantList: List<Restaurant?>,
    foodList: List<Food?>,
) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                DrawerHeader(user)
                if (user != null) {
                    DrawerBody(user.userPref) { route ->
                        navController.navigate(route)
                    }
                }
            }
        },
    ) {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                TopBar(scope, drawerState)
            },
        ) {
                paddingValue ->
            Column(
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .background(CoolGrey)
                        .padding(paddingValue),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                FocusTextField()
                HomeBody()
            }
        }
    }
}
