package com.example.capstoneproject.preferences.selector

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.capstoneproject.ui.theme.PartyPink

@Suppress("ktlint:standard:function-naming")
@Composable
fun CheckboxItem(
    text: String,
    isChecked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.clickable { onCheckedChange(!isChecked) },
    ) {
        Checkbox(
            colors =
                CheckboxDefaults.colors(
                    checkedColor = PartyPink,
                ),
            checked = isChecked,
            onCheckedChange = null,
        )
        Text(
            text = text,
            modifier = Modifier.padding(start = 8.dp),
        )
    }
}
