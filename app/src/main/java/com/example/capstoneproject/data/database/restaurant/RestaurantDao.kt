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

    @Query("Delete FROM restaurant WHERE restaurant_id = :restaurantId")
    suspend fun deleteRestaurant(restaurantId: Int)

    //@Update
    //suspend fun updateRestaurant(restaurant: Restaurant)

    //get all categories (retrieve the name and ids)
    @Query("Select * FROM restaurant")
    fun getAllRestaurant() : Flow<List<Restaurant>>
}
