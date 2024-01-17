package com.example.capstoneproject.preferences

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Suppress("ktlint:standard:function-naming")
@Composable
fun UserClassificationChoiceTextUI() {
    Text(
        "Are you ...",
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
    )
    Text("(Choose one only)")
}

@Suppress("ktlint:standard:function-naming")
@Composable
fun FoodPreferenceChoiceTextUI() {
    Text(
        "What type of food do you like?",
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
    )
    Text("(Multiple choices allowed)")
}

@Suppress("ktlint:standard:function-naming")
@Composable
fun BudgetTextUI(userBudget: Int) {
    Row {
        Text(
            "Budget:",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(end = 16.dp),
        )

        Text(
            "$$userBudget",
            fontSize = 20.sp,
        )
    }
}
