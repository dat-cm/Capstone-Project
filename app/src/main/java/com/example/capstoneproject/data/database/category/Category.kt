package com.example.capstoneproject.data.database.category

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "category")
data class Category(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("category_id") var categoryId: Int = 0,
    @ColumnInfo ("category_name") var categoryName: String,
)
