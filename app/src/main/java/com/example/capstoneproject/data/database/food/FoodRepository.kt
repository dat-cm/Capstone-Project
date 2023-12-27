package com.example.capstoneproject.data.database.food
import kotlinx.coroutines.flow.Flow

class FoodRepository(private val foodDao: FoodDao) {
    suspend fun insertFood(food:Food) = foodDao.insertFood(food)
    suspend fun deleteFood(food:Food) = foodDao.deleteFood(food)
    suspend fun updateFood(food:Food) = foodDao.updateFood(food)
    fun getAllFood(): Flow<List<Food>> = foodDao.getAllFood()
    fun getSpecificFood(restaurantId: Int, foodCategory: String): Flow<Food> = foodDao.getSpecificFoodUsingRestaurantId(restaurantId, foodCategory)
}