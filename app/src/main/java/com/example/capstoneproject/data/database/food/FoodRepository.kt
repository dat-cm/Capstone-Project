package com.example.capstoneproject.data.database.food
import kotlinx.coroutines.flow.Flow

class FoodRepository(private val foodDao: FoodDao) {
    suspend fun insertFood(food:Food) = foodDao.insertFood(food)
    suspend fun deleteFood(id:Int) = foodDao.deleteFood(id)
    suspend fun updateFoodImage(image: String, foodId: Int)
    = foodDao.updateFoodImage(image, foodId)
    suspend fun updateFoodCategory(category: List<String>, foodId: Int)
        = foodDao.updateFoodCategory(category, foodId)
    fun getAllFood(): Flow<List<Food>> = foodDao.getAllFood()
    fun getSpecificFood(restaurantId: Int, foodCategory: String): Flow<List<Food?>>
    = foodDao.getSpecificFoodUsingRestaurantId(restaurantId, foodCategory)

    fun getSpecificFoodUsingCategory(foodCategory: String): Flow<List<Food?>>
        = foodDao.getSpecificFoodUsingCategory(foodCategory)

}