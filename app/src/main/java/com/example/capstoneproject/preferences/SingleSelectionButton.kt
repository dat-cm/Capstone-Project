package com.example.capstoneproject.preferences

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.capstoneproject.ui.theme.PartyPink

@Composable
fun TypePreferenceChoice(){
    Text(
        "Are you ...",
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
    )
    Text("(Choose one only)")
    SingleSelect()
}

@Composable
fun SingleSelect() : String {
    var selectedOption by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        SingleSelectItem("Halal", selectedOption, onSelected = { selectedOption = it })
        SingleSelectItem("Non-Halal", selectedOption, onSelected = { selectedOption = it })
        SingleSelectItem("Vegetarian", selectedOption, onSelected = { selectedOption = it })
        SingleSelectItem("Vegan", selectedOption, onSelected = { selectedOption = it })
    }
    return selectedOption
}

@Composable
fun SingleSelectItem(
    text: String,
    selectedOption: String,
    onSelected: (String) -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.clickable { onSelected(text) }
    ) {
        RadioButton(
            colors = RadioButtonDefaults.colors(
                selectedColor = PartyPink,
            ),
            selected = text == selectedOption,
            onClick = null // null disables manual clicking, rely on the clickable modifier
        )
        Text(
            text = text,
            modifier = Modifier.padding(start = 8.dp)
        )
    }
}