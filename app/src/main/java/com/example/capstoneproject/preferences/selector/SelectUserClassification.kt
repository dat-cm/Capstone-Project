package com.example.capstoneproject.preferences.selector

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun selectUserClassification(userPref: String) : String {
    val selectedOption: MutableState<String> = if(userPref != "") {
        remember { mutableStateOf(userPref) }
    }else{
        remember { mutableStateOf("") }
    }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        SingleSelectItem("Halal", selectedOption) { selectedOption.value = it }
        SingleSelectItem("Non-Halal", selectedOption) { selectedOption.value = it }
        SingleSelectItem("Vegan/Vegetarian", selectedOption) { selectedOption.value = it }
        SingleSelectItem("No Preference", selectedOption) { selectedOption.value = it }
    }
    Log.i("single", selectedOption.value)

    return selectedOption.value
}
