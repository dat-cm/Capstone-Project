package com.example.capstoneproject.data.database.food

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.capstoneproject.data.databasepages.ToInsertCategory
import kotlinx.coroutines.flow.Flow

@Dao
interface FoodDao {
    //food
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFood(food: Food)

    @Query("Delete FROM food WHERE food_id = :foodId")
    suspend fun deleteFood(foodId: Int)

    @Query("Update food Set food_image = :image Where food_id = :foodId")
    suspend fun updateFoodImage(image: String, foodId: Int)

    @Query("Update food Set food_category = :category Where food_id = :foodId")
    suspend fun updateFoodCategory(category: String, foodId: Int)

    //get all categories (retrieve the name and ids)
    @Query("Select * FROM food")
    fun getAllFood() : Flow<List<Food>>

    //get specific food
    //(to retrieve specific food info using restaurant_id and category
    // which matches the restaurant_category and category)
    @Query("Select * FROM food WHERE restaurant_id = :restaurantId AND food_category = :foodCategory")
    fun getSpecificFoodUsingRestaurantId(restaurantId: Int, foodCategory: String): Flow<Food>

}