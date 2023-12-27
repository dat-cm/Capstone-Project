package com.example.capstoneproject.data.database.food

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface FoodDao {
    //food
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFood(food: Food)

    @Delete
    suspend fun deleteFood(food: Food)

    @Update
    suspend fun updateFood(food: Food)

    //get all categories (retrieve the name and ids)
    @Query("Select * FROM food")
    fun getAllFood() : Flow<List<Food>>

    //get specific food
    //(to retrieve specific food info using restaurant_id and category
    // which matches the restaurant_category and category)
    @Query("Select * FROM food WHERE restaurant_id = :restaurantId AND food_category = food_category")
    fun getSpecificFoodUsingRestaurantId(restaurantId: Int, foodCategory: String): Flow<Food>

}