package com.example.capstoneproject.data.database.userfavourite

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("user_favourite")
data class UserFavourite(
    @ColumnInfo("user_id") var userId: Int,
    @ColumnInfo("restaurant_id") var restaurantId: Int,
    @ColumnInfo("food_id") var foodId : Int,
    @ColumnInfo("recurring") var isRecur : Boolean = false,
    @ColumnInfo("recurTime") var recurTime: String? = null,
    @ColumnInfo("recurDate") var recurDate: List<String?> = emptyList()
){
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("fav_id") var favId: Int = 0
}
