package com.example.capstoneproject.data.database.category

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "category")
data class Category(
    @ColumnInfo ("category_name") var categoryName: String,
    @ColumnInfo("category_type") var categoryType: String,
){
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("category_id") var categoryId: Int = 0
}
