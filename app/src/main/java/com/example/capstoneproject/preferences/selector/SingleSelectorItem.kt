package com.example.capstoneproject.preferences.selector

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.capstoneproject.ui.theme.PartyPink

@Composable
fun SingleSelectItem(
    text: String,
    selectedOption: MutableState<String>,
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
            selected = text == selectedOption.value,
            onClick = null // null disables manual clicking, rely on the clickable modifier
        )
        Text(
            text = text,
            modifier = Modifier.padding(start = 8.dp)
        )
    }
}
