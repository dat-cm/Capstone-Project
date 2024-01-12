package com.example.capstoneproject.preferences

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import com.example.capstoneproject.data.database.CapstoneViewModel
import com.example.capstoneproject.data.database.user.User
import com.example.capstoneproject.data.database.userpreferences.UserPreferences
import com.example.capstoneproject.data.insert.addToListForInsert
import com.example.capstoneproject.navigator.Routes
import com.example.capstoneproject.preferences.multiselect.multiSelectForHalalOrNonHalal
import com.example.capstoneproject.preferences.multiselect.multiSelectForVegetarianOrVegan
import com.example.capstoneproject.preferences.selector.selectUserClassification
import com.example.capstoneproject.preferences.slider.budgetSlider
import com.example.capstoneproject.ui.theme.PartyPink
import kotlinx.coroutines.launch

@Suppress("ktlint:standard:function-naming")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PreferencesUI(
    navController: NavHostController,
    capstoneViewModel: CapstoneViewModel,
    user: User?,
    userPref: UserPreferences?,
) {
    var userClassification by remember { mutableStateOf("") }
    var userFoodPreferences = remember { mutableStateListOf("") }
    var userBudget by remember { mutableIntStateOf(0) }

    Scaffold(
        topBar = {
            Surface(
                shadowElevation = 2.dp,
            ) {
                TopAppBar(
                    title = { Text("Preferences") },
                    navigationIcon = {
                        IconButton(onClick = { navController.navigate(Routes.Selection.route) }) {
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
    ) { // to do list view from firebase
            paddingValue ->
        Column(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .padding(
                        top = paddingValue.calculateTopPadding() + 8.dp,
                        start = 16.dp,
                        end = 16.dp,
                    ),
        ) {
            // halal/non-halal/...
            UserClassificationChoiceTextUI()
            userClassification = selectUserClassification(userPref?.userClassification ?: "")
            if (userClassification != "") {
                FoodPreferenceChoiceTextUI()
                when (userClassification) {
                    "Halal", "Non-Halal", "No Preference" ->
                        userFoodPreferences = multiSelectForHalalOrNonHalal(userPref?.userFoodClassification ?: emptyList())

                    "Vegan/Vegetarian" ->
                        userFoodPreferences = multiSelectForVegetarianOrVegan(userPref?.userFoodClassification ?: emptyList())
                }
                if (userFoodPreferences.isNotEmpty()) {
                    Row {
                        Text(
                            "Budget:",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(end = 16.dp),
                        )

                        Text(
                            "$$userBudget",
                            fontSize = 20.sp,
                        )
                    }
                    userBudget = budgetSlider(userPref?.userBudget?.toInt() ?: 0)
                }
            }

            // save button
            Button(
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .padding(top = 40.dp),
                colors = ButtonDefaults.buttonColors(PartyPink),
                onClick = {
                    var userFoodPreferencesList: ArrayList<String>
                    capstoneViewModel.viewModelScope.launch {
                        userFoodPreferencesList = addToListForInsert(userFoodPreferences)
                        if (user != null) {
                            if (userPref != null) {
                                capstoneViewModel.updateAllUserPreferences(
                                    UserPreferences(
                                        user.userId,
                                        userClassification,
                                        userFoodPreferencesList,
                                        userBudget.toDouble(),
                                    ),
                                )
                            } else {
                                capstoneViewModel.insertUserPref(
                                    UserPreferences(
                                        user.userId,
                                        userClassification,
                                        userFoodPreferencesList,
                                        userBudget.toDouble(),
                                    ),
                                )
                                if (!user.userPref) {
                                    capstoneViewModel.updateUserPref(true)
                                }
                            }
                        }
                    }
                    navController.navigate(Routes.Selection.route)
                },
            ) {
                Text("Save")
            }
        }
    }
}
