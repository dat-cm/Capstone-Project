package com.example.capstoneproject.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.capstoneproject.data.database.category.Category
import com.example.capstoneproject.data.database.category.CategoryDao
import com.example.capstoneproject.data.database.food.Food
import com.example.capstoneproject.data.database.food.FoodDao
import com.example.capstoneproject.data.database.restaurant.Restaurant
import com.example.capstoneproject.data.database.restaurant.RestaurantDao
import com.example.capstoneproject.data.database.user.User
import com.example.capstoneproject.data.database.user.UserDao
import com.example.capstoneproject.data.database.userpreferences.UserPreferences
import com.example.capstoneproject.data.database.userpreferences.UserPreferencesDao

@Database(
    entities =
    [Category::class,
        Food::class,
        Restaurant::class,
        //User::class,
        //UserPreferences::class
    ],
    version =  1)
abstract class CapstoneDatabase : RoomDatabase(){
    abstract fun foodDao(): FoodDao
    abstract fun restaurantDao(): RestaurantDao
    abstract fun categoryDao(): CategoryDao
    //abstract fun userDao() :UserDao
    //abstract fun userPreferencesDao(): UserPreferencesDao

    companion object{
        @Volatile
        private var Instance:CapstoneDatabase? = null
        fun getDatabase(context: Context): CapstoneDatabase{
            return Instance ?: synchronized(this){
                Room.databaseBuilder(context, CapstoneDatabase::class.java, "capstone_database")
                    .build()
                    .also { Instance = it }
            }
        }
    }
}