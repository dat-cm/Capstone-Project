package com.example.capstoneproject.preferences

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
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
