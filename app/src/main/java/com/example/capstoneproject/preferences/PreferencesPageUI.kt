/*
This file is used to create UI for "Edit Subscriptions"
*/
package com.example.capstoneproject.preferences

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.capstoneproject.navigator.Routes
import com.example.capstoneproject.ui.theme.PartyPink

class PreferencesPageUI {
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun BuildPreferencesUI(navController: NavHostController) {
        Scaffold(
            topBar = {
                Surface(
                    shadowElevation = 2.dp,
                ) {
                    TopAppBar(title = { Text("Preferences") },
                        navigationIcon = {
                            IconButton(onClick = { navController.navigate(Routes.Selection.route) }) {
                                Icon(
                                    imageVector = Icons.Default.Close,
                                    contentDescription = "Close",
                                    tint = PartyPink
                                )
                            }
                        }
                    )
                }
            }
        ) { //to do list view from firebase
                paddingValue ->
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        top = paddingValue.calculateTopPadding() + 8.dp,
                        start = 16.dp,
                        end = 16.dp
                    ),
            ) {
                //halal/non-halal/...
                TypePreferenceChoice()

                //Food preference choice
                FoodPreferenceChoiceHalalOrNonHalal()

                //save button
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 40.dp),
                    colors = ButtonDefaults.buttonColors(PartyPink),
                    onClick = { //do something in firebase
                        navController.navigate(Routes.Selection.route)
                         }) {
                    Text("Save")
                }
            }
        }
    }


    @Composable
    fun FoodPreferenceChoiceHalalOrNonHalal(){
        Text(
            "What type of food do you like?",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold)
        Text("(Multiple choices allowed)")
        MultiSelectForHalalOrNonHalal()
    }

    @Composable
    fun FoodPreferenceChoiceForVegetarian(){
        Text(
            "What type of food do you like?",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold)
        Text("(Multiple choices allowed)")
    }





}