package com.example.capstoneproject.data.database.food

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "food")
data class Food(
    @PrimaryKey (autoGenerate = true)
    @ColumnInfo("food_id") var foodId : Int,
    @ColumnInfo ("food_name") var foodName: String,
    @ColumnInfo ("food_price") var foodPrice: Double,
    @ColumnInfo("food_category") var foodCategory: List<String>,
    @ColumnInfo("food_image") var foodImage: String,
    @ColumnInfo("restaurant_id") var restaurantId: Int,
)