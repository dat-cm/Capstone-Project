package com.example.capstoneproject.recurring

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.capstoneproject.data.database.CapstoneViewModel
import com.example.capstoneproject.data.decimal.formatToTwoDecimalPlaces
import com.example.capstoneproject.navigator.Routes
import com.example.capstoneproject.recurring.daypicker.DayPicker
import com.example.capstoneproject.recurring.timepicker.TimePicker
import com.example.capstoneproject.ui.theme.PartyPink
import kotlinx.coroutines.launch

@Suppress("ktlint:standard:function-naming")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecurringUI(
    capstoneViewModel: CapstoneViewModel,
    navController: NavHostController,
    foodName: String?,
    foodPrice: Double?,
    restaurant: String?,
    image: String?,
    favId: Int?,
) {
    var selectedTime by remember { mutableStateOf("") }
    var selectedDays by remember { mutableStateOf<List<String>>(emptyList()) }
    var imageUrl: String

    Scaffold(
        topBar = {
            Surface(
                shadowElevation = 2.dp,
            ) {
                TopAppBar(
                    title = { Text("Recurring Orders") },
                    navigationIcon = {
                        IconButton(onClick = { navController.navigate(Routes.Like.route) }) {
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
    ) {
            paddingValues ->
        Column(
            modifier =
                Modifier
                    .fillMaxSize()
                    .padding(top = paddingValues.calculateTopPadding(), start = 16.dp, end = 16.dp)
                    .background(color = Color.White)
                    .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Placeholders for food name, price, restaurant and image
            Spacer(modifier = Modifier.height(8.dp))
            Row {
                Text("Meal: ", fontSize = 20.sp)
                if (foodName != null) {
                    Text(foodName, fontSize = 20.sp)
                }
            }

            Spacer(modifier = Modifier.height(8.dp))
            Row {
                Text("Price: ", fontSize = 20.sp)
                Text("$${foodPrice.formatToTwoDecimalPlaces()}", fontSize = 20.sp)
            }

            Spacer(modifier = Modifier.height(8.dp))
            Row {
                Text("Restaurant: ", fontSize = 20.sp)
                if (restaurant != null) {
                    Text(restaurant, fontSize = 20.sp)
                }
            }

            Spacer(modifier = Modifier.height(8.dp))
            Text("Image ", fontSize = 20.sp)

            Card(
                modifier = Modifier.padding(24.dp),
                shape = CircleShape,
                border = BorderStroke(2.dp, color = PartyPink),
            ) {
                imageUrl = image!!
                AsyncImage(
                    model = imageUrl,
                    contentDescription = null,
                    modifier = Modifier.size(200.dp),
                    contentScale = ContentScale.Crop,
                )
            }

            Spacer(modifier = Modifier.height(8.dp))
            Text("Pick the time to receive your meal", fontSize = 20.sp)
            Spacer(modifier = Modifier.height(8.dp))
            // Time picker
            TimePicker()

            Spacer(modifier = Modifier.height(8.dp))
            Text("Pick the days you want it to recur", fontSize = 20.sp)
            Spacer(modifier = Modifier.height(8.dp))
            // Day picker
            DayPicker { days ->
                selectedDays = days
            }
            Spacer(modifier = Modifier.height(8.dp))

            // Confirm and Cancel buttons
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
            ) {
                Button(
                    enabled = selectedTime != "" && selectedDays.isNotEmpty(),
                    onClick = {
                        Log.i("id", favId.toString())
                        Log.i("selected time", selectedTime)
                        selectedDays.forEach {
                                day ->
                            Log.i("day", day)
                        }

                        capstoneViewModel.viewModelScope.launch {
                            capstoneViewModel.updateRecurrence(favId!!, true, selectedTime, selectedDays)
                        }
                        // Handle Confirm Button
                        navController.navigate(Routes.Like.route)
                    },
                    modifier = Modifier.weight(1f),
                    colors = ButtonDefaults.buttonColors(PartyPink),
                ) {
                    Text("Confirm")
                }

                Spacer(modifier = Modifier.width(16.dp))

                Button(
                    onClick = {
                        // Handle Cancel Button
                        navController.navigate(Routes.Like.route)
                    },
                    modifier = Modifier.weight(1f),
                ) {
                    Text("Cancel")
                }
            }
        }
    }
}
