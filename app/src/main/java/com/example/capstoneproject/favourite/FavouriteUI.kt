package com.example.capstoneproject.favourite

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.*
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
    var selectedRecurIndex by remember { mutableIntStateOf(0) }
    var selectedTabIndex by remember { mutableIntStateOf(0) }
    val scrollState = rememberScrollState()
    val dayList = listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
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
            TabRow(
                selectedTabIndex = selectedRecurIndex,
                modifier = Modifier
                    .padding(paddingValues)
                    .height(60.dp),
                indicator = { tabPositions ->
                    TabRowDefaults.Indicator(
                        modifier = Modifier.tabIndicatorOffset(tabPositions[selectedRecurIndex]),
                        color = PartyPink
                    )
                }) {
                Tab(
                    selected = selectedRecurIndex == 0,
                    onClick = { selectedRecurIndex = 0 },
                    selectedContentColor = PartyPink
                ) {
                    Text(
                        text = "Set Recurring",
                        fontSize = 24.sp,
                        textAlign = TextAlign.Center,
                        color = if (selectedRecurIndex == 0) {
                            PartyPink
                        } else {
                            Color.Black
                        },
                    )
                }
                Tab(
                    selected = selectedRecurIndex == 1,
                    onClick = { selectedRecurIndex = 1 },
                    selectedContentColor = PartyPink
                ) {
                    Text(
                        text = "Recurring",
                        fontSize = 24.sp,
                        textAlign = TextAlign.Center,
                        color = if (selectedRecurIndex == 1) {
                            PartyPink
                        } else {
                            Color.Black
                        },
                    )
                }
            }
            when (selectedRecurIndex) {
                0 ->
                    LazyColumn(
                        modifier = Modifier.padding(top = paddingValues.calculateTopPadding() + 60.dp),
                    ) {
                        items(userFav) { item ->
                            if (item != null) {
                                if (!item.isRecur) {
                                    ExpandableFoodItem(item, navController, restaurant, foodList, capstoneViewModel)
                                }
                            }

                        }
                    }

                1 -> Column(
                    modifier = Modifier.padding(top = paddingValues.calculateTopPadding() + 50.dp)
                ) {
                    LazyRow(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        items(dayList) { tab ->
                            Tab(
                                text = { Text(text = dayList[dayList.indexOf(tab)]) },
                                selected = true, // Set this to the current selected tab
                                onClick = { selectedTabIndex = dayList.indexOf(tab) },
                                selectedContentColor =
                                if (dayList.indexOf(tab) == selectedTabIndex) {
                                    PartyPink
                                } else {
                                    Color.Black
                                }
                            )
                        }
                    }
                    when (selectedTabIndex) {
                        selectedTabIndex -> LazyColumn() {
                            items(userFav) { item ->
                                if (item != null) {
                                    if (item.isRecur) {
                                        item.recurDate.forEach { day ->
                                            if (day == dayList[selectedTabIndex]) {
                                                ExpandableFoodItem(
                                                    item,
                                                    navController,
                                                    restaurant,
                                                    foodList,
                                                    capstoneViewModel
                                                )
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
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
