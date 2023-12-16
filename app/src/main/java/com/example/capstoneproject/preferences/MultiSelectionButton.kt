package com.example.capstoneproject.preferences

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import com.example.capstoneproject.ui.theme.PartyPink
import androidx.compose.ui.Modifier

@Composable
fun MultiSelectForHalalOrNonHalal(){
    val selectedOptions = remember { mutableStateListOf<String>() }
    val options = listOf("Fast Food", "Seafood", "BBQ & Grill",
        "Street Food", "Beverages", "Noodles", "Rice")

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
}

@Composable
fun CheckboxItem(
    text: String,
    isChecked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.clickable { onCheckedChange(!isChecked) }
    ) {
        Checkbox(
            colors= CheckboxDefaults.colors(
                checkedColor = PartyPink
            ),
            checked = isChecked,
            onCheckedChange = null // null disables manual clicking, rely on the clickable modifier
        )
        Text(
            text = text,
            modifier = Modifier.padding(start = 8.dp)
        )
    }
}