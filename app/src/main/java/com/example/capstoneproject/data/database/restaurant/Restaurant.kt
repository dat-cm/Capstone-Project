package com.example.capstoneproject.data.database.restaurant

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "restaurant")
data class Restaurant(
    @ColumnInfo ("restaurant_name") var restaurantName: String,
    @ColumnInfo ("restaurant_category") var restaurantCategory : String
){
    @PrimaryKey (autoGenerate = true)
    @ColumnInfo("restaurant_id") var restaurantId: Int = 0
}
