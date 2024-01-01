package com.example.capstoneproject.data.database.user

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "user")
data class User(
    @ColumnInfo("user_name") var userName: String
){
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("user_id")
    var userId: Int = 0
}
