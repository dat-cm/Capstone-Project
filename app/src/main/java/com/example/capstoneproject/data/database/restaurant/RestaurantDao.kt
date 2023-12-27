package com.example.capstoneproject.data.database.restaurant

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface RestaurantDao
{
    //restaurant
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRestaurant(restaurant: Restaurant)

    @Delete
    suspend fun deleteRestaurant(restaurant: Restaurant)

    @Update
    suspend fun updateRestaurant(restaurant: Restaurant)

    //get all categories (retrieve the name and ids)
    @Query("Select * FROM restaurant")
    fun getAllRestaurant() : Flow<List<Restaurant>>

    //get specific restaurant
    //(to retrieve specific ids of restaurant which matches the restaurant_category)
    @Query("Select * FROM restaurant WHERE restaurant_category = :categoryName")
    fun getSpecificRestaurantUsingCategory(categoryName: String): Flow<Restaurant>


}