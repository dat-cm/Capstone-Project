package com.example.capstoneproject.data.database.userpreferences

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
@Entity(tableName = "user_preference")
data class UserPreferences(
    @ColumnInfo("restaurant_id") var restaurantId: Int,
    @ColumnInfo("food_id") var foodId : Int
){
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo("user_id")
    var userId: Int = 0
}
