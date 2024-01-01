package com.example.capstoneproject.data.database.restaurant

import com.example.capstoneproject.data.database.food.Food
import kotlinx.coroutines.flow.Flow

class RestaurantRepository(private val restaurantDao: RestaurantDao) {
    suspend fun insertRestaurant(restaurant: Restaurant)
    = restaurantDao.insertRestaurant(restaurant)
    suspend fun deleteRestaurant(restaurantId: Int)
    = restaurantDao.deleteRestaurant(restaurantId)
    //suspend fun updateRestaurant(restaurant: Restaurant)
    //= restaurantDao.updateRestaurant(restaurant)
    fun getAllRestaurant(): Flow<List<Restaurant>>
    = restaurantDao.getAllRestaurant()
    fun getSpecificRestaurantUsingCategory(category: String): Flow<Restaurant> =
        restaurantDao.getSpecificRestaurantUsingCategory(category)

}