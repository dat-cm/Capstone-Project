package com.example.capstoneproject.preferences.slider

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Slider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun budgetSlider(userBudget: Int) : Int{
    val userBudgetCost: MutableState<Int> = if(userBudget != 0) {
        remember { mutableIntStateOf(userBudget) }
    }else{
        remember { mutableIntStateOf(0) }
    }
    Slider(
        value = userBudgetCost.value.toFloat(),
        onValueChange = {
                newValue -> userBudgetCost.value = newValue.toInt()
        },
        valueRange = 0.00f..100.00f,
        steps = 100,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp)
            .height(48.dp)
    )
    return userBudgetCost.value
}
