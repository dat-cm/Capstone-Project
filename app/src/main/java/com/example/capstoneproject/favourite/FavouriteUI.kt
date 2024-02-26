package com.example.capstoneproject.favourite

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.capstoneproject.data.database.CapstoneViewModel
import com.example.capstoneproject.data.database.food.Food
import com.example.capstoneproject.data.database.restaurant.Restaurant
import com.example.capstoneproject.data.database.userfavourite.UserFavourite
import com.example.capstoneproject.favourite.cards.ExpandableFoodItem
import com.example.capstoneproject.navigator.Routes
import com.example.capstoneproject.ui.theme.PartyPink

@Suppress("ktlint:standard:function-naming")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FavouriteUI(
    navController: NavHostController,
    restaurant: List<Restaurant?>,
    userFav: List<UserFavourite?>,
    foodList: List<Food?>,
    capstoneViewModel: CapstoneViewModel
) {
    Scaffold(
        topBar = {
            Surface(
                shadowElevation = 2.dp,
            ) {
                TopAppBar(
                    title = { Text("My Likings") },
                    navigationIcon = {
                        IconButton(onClick = { navController.navigate(Routes.Home.route) }) {
                            Icon(
                                imageVector = Icons.Default.Close,
                                contentDescription = "Close",
                                tint = PartyPink,
                            )
                        }
                    },
                )
            }
        },
    ) { paddingValues ->
        if (userFav.isNotEmpty()) {
            LazyColumn(
                modifier = Modifier.padding(paddingValues),
            ) {
                items(userFav) { item ->
                    ExpandableFoodItem(item, navController, restaurant, foodList, capstoneViewModel)
                }
            }
        } else {
            Column(
                modifier =
                Modifier
                    .padding(
                        start = 16.dp,
                        end = 16.dp,
                    )
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    "Head over to Food Subscription to start liking your Food",
                    fontSize = 24.sp,
                    textAlign = TextAlign.Center,
                )
                Spacer(modifier = Modifier.padding(top = 16.dp))
                Button(
                    onClick = { navController.navigate(Routes.Selection.route) },
                    colors = ButtonDefaults.buttonColors(PartyPink),
                ) {
                    Text("Go")
                }
            }
        }
    }
}
