package com.example.capstoneproject.recurring.daypicker

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.capstoneproject.ui.theme.PartyPink

@Suppress("ktlint:standard:function-naming")
@Composable
fun DayPicker(onDaysSelected: (List<String>) -> Unit) {
    val days =
        listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    var expanded by remember { mutableStateOf(false) }
    val selectedDays = remember { mutableStateListOf<String>() }

    Column {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier =
                Modifier
                    .clickable { expanded = !expanded }
                    .padding(vertical = 8.dp)
                    .fillMaxWidth()
                    .background(color = Color.White),
        ) {
            Text(
                text = if (selectedDays.isEmpty()) "Choose your days" else selectedDays.joinToString(),
                modifier =
                    Modifier
                        .padding(8.dp)
                        .weight(1f),
            )
            Icon(
                imageVector = Icons.Default.ArrowDropDown,
                contentDescription = "Dropdown Arrow",
                modifier = Modifier.padding(end = 8.dp),
            )
        }

        if (expanded) {
            Column(
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .background(color = Color.White)
                        .padding(vertical = 4.dp),
            ) {
                days.forEach { day ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier =
                            Modifier
                                .padding(horizontal = 24.dp, vertical = 4.dp),
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
                            colors =
                                CheckboxDefaults.colors(
                                    checkedColor = PartyPink,
                                    uncheckedColor = PartyPink,
                                    checkmarkColor = Color.White,
                                ),
                        )
                        Text(
                            text = day,
                            modifier = Modifier.padding(start = 4.dp),
                        )
                    }
                }
            }
        }
    }
}
