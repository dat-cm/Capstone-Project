package com.example.capstoneproject.recurring

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.capstoneproject.data.decimal.formatToTwoDecimalPlaces
import com.example.capstoneproject.navigator.Routes
import com.example.capstoneproject.ui.theme.PartyPink

class RecurPageUI {
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun BuildRecurUI(
        navController: NavHostController,
        foodName: String?,
        foodPrice: Double?,
        restaurant: String?,
        image: String?,
    ) {
        var selectedTime by remember { mutableStateOf("") }
        var selectedDays by remember { mutableStateOf<List<String>>(emptyList()) }
        var imageUrl: String

        Scaffold(
            topBar = {
                Surface(
                    shadowElevation = 2.dp,
                ) {
                    TopAppBar(title = { Text("Recurring Orders") },
                        navigationIcon = {
                            IconButton(onClick = { navController.navigate(Routes.Like.route)}) {
                                Icon(
                                    imageVector = Icons.Default.Close,
                                    contentDescription = "Close",
                                    tint = PartyPink
                                )
                            }
                        }
                    )
                }
            }) {
            paddingValues->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top =  paddingValues.calculateTopPadding(),start =16.dp, end =16.dp)
                    .background(color = Color.White)
                    .verticalScroll(rememberScrollState())

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
                        contentScale = ContentScale.Crop
                    )
                }


                Spacer(modifier = Modifier.height(8.dp))
                Text("Pick the time to receive your meal", fontSize = 20.sp)
                Spacer(modifier = Modifier.height(8.dp))
                // Time picker
                TimePicker() { time ->
                    selectedTime = time
                }

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
                    horizontalArrangement = Arrangement.Center
                ) {
                    Button(
                        onClick = {
                            //Handle Confirm Button
                            navController.navigate(Routes.Home.route)
                        },
                        modifier = Modifier.weight(1f),
                        colors = ButtonDefaults.buttonColors(PartyPink)
                    ) {
                        Text("Confirm")
                    }

                    Spacer(modifier = Modifier.width(16.dp))

                    Button(
                        onClick = {
                            //Handle Cancel Button
                            navController.navigate(Routes.Like.route)
                        },
                        modifier = Modifier.weight(1f)
                    ) {
                        Text("Cancel")
                    }
                }
            }
        }
    }

    @Composable
    fun DayPicker(onDaysSelected: (List<String>) -> Unit) {
        val days =
            listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
        var expanded by remember { mutableStateOf(false) }
        val selectedDays = remember { mutableStateListOf<String>() }

        Column {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .clickable { expanded = !expanded }
                    .padding(vertical = 8.dp)
                    .fillMaxWidth()
                    .background(color = Color.White)
            ) {
                Text(
                    text = if (selectedDays.isEmpty()) "Choose your days" else selectedDays.joinToString(),
                    modifier = Modifier
                        .padding(8.dp)
                        .weight(1f)
                )
                Icon(
                    imageVector = Icons.Default.ArrowDropDown,
                    contentDescription = "Dropdown Arrow",
                    modifier = Modifier.padding(end = 8.dp)
                )
            }

            if (expanded) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Color.White)
                        .padding(vertical = 4.dp)
                ) {
                    days.forEach { day ->
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .padding(horizontal = 24.dp, vertical = 4.dp)
                        ) {
                            Checkbox(
                                checked = selectedDays.contains(day),
                                onCheckedChange = {
                                    if (day == "Just for today") {
                                        selectedDays.clear()
                                        selectedDays.add(day)
                                    } else {
                                        if (selectedDays.contains("Just for today")) {
                                            selectedDays.remove("Just for today")
                                        }
                                        if (selectedDays.contains(day)) {
                                            selectedDays.remove(day)
                                        } else {
                                            selectedDays.add(day)
                                        }
                                    }
                                    onDaysSelected(selectedDays)
                                },
                                modifier = Modifier.padding(end = 8.dp),
                                colors = CheckboxDefaults.colors(
                                    checkedColor = PartyPink,
                                    uncheckedColor = PartyPink,
                                    checkmarkColor = Color.White
                                )
                            )
                            Text(
                                text = day,
                                modifier = Modifier.padding(start = 4.dp)
                            )
                        }
                    }
                }
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun TimePicker(onTimeSelected: (String) -> Unit) {
        val myState = rememberTimePickerState(9, 15, false)
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            TimeInput(state = myState)
            Text(
                text = "Time picked is ${
                    if (myState.hour >= 12) {
                        "${myState.hour % 12}:${String.format("%02d", myState.minute)} PM"
                    } else {
                        "${myState.hour}:${String.format("%02d", myState.minute)} AM"
                    }
                }"
            )

        }

    }
}
