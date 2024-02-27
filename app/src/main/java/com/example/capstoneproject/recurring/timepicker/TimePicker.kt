package com.example.capstoneproject.recurring.timepicker

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TimeInput
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment

@Suppress("ktlint:standard:function-naming")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TimePicker() {
    val myState = rememberTimePickerState(9, 15, false)
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        TimeInput(state = myState)
        Text(
            text = "Time picked is ${
                if (myState.hour >= 12) {
                    "${myState.hour % 12}:${String.format("%02d", myState.minute)} PM"
                } else {
                    "${myState.hour}:${String.format("%02d", myState.minute)} AM"
                }
            }",
        )
    }
}
