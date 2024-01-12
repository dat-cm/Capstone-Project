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
fun multiSelectForHalalOrNonHalal(userFoodClassification: List<String>) : SnapshotStateList<String> {
    val options = listOf(
        "Meat",
        "Rice",
        "Dessert",
        "Noodles",
        "Seafood",
        "Fast food",
    )
    var selectedOptions: SnapshotStateList<String> = remember { mutableStateListOf() }
    if(userFoodClassification.isNotEmpty()) {
        selectedOptions = remember {
            convertToSnapshotStateList(userFoodClassification, options)
        }
    }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)) {
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
                }
            )
        }
    }
    return selectedOptions
}

@Composable
fun multiSelectForVegetarianOrVegan(userFoodClassification: List<String>) : SnapshotStateList<String> {
    val options = listOf(
        "Rice",
        "Soup",
        "Salad",
        "Dessert",
        "Noodles",
        "Fast food",
    )
    var selectedOptions: SnapshotStateList<String> = remember { mutableStateListOf() }
    if(userFoodClassification.isNotEmpty()) {
        selectedOptions = remember {
            convertToSnapshotStateList(userFoodClassification, options)
        }
    }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)) {
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
                }
            )
        }
    }
    return selectedOptions
}
