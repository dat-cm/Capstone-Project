package com.example.capstoneproject.data.database.userpreferences

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "user_preferences")
data class UserPreferences(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo("user_id") var userId: Int,
    @ColumnInfo("user_classification") var userClassification: String,
    @ColumnInfo("user_food_classification") var userFoodClassification: List<String>,
    @ColumnInfo("user_budget") var userBudget: Double
)
