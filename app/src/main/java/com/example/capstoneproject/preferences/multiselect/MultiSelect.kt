package com.example.capstoneproject.preferences.multiselect

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.capstoneproject.data.converters.convertToSnapshotStateList
import com.example.capstoneproject.preferences.selector.CheckboxItem

@Composable
fun multiSelectionFoodClassification(
    userClassification: String,
    userFoodClassification: List<String>,
): SnapshotStateList<String> {
    var options = listOf<String>()
    when (userClassification) {
        "Halal" ->
            options =
                listOf(
                    "Malaysian Cuisine",
                    "Japanese Cuisine",
                    "Western Cuisine",
                )
        "Non-Halal" ->
            options =
                listOf(
                    "Chinese Cuisine",
                    "Korean Cuisine",
                    "Thai Cuisine"
            )

        "Vegan" ->
            options =
                listOf(
                    "American Vegan Cuisine",
                    "Asian Vegan Cuisine",
                    "Indian Vegan Cuisine",
                )

        "Vegetarian" ->
            options =
                listOf(
                    "East Asian Vegetarian Cuisine",
                    "Vegetarian Fusion Cuisine",
                    "Western Vegetarian Cuisine:",
                )
    }

    var selectedOptions: SnapshotStateList<String> = remember { mutableStateListOf() }
    if (userFoodClassification.isNotEmpty()) {
        selectedOptions =
            remember {
                convertToSnapshotStateList(userFoodClassification, options)
            }
    }
    Column(
        modifier =
            Modifier
                .padding(16.dp)
                .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        options.forEach { option ->
            CheckboxItem(
                text = option,
                isChecked = selectedOptions.contains(option),
                onCheckedChange = { isChecked ->
                    if (isChecked) {
                        selectedOptions.add(option)
                    } else {
                        selectedOptions.remove(option)
                    }
                },
            )
        }
    }
    return selectedOptions
}
