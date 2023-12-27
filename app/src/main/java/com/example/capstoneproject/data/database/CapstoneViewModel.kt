package com.example.capstoneproject.data.database

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.capstoneproject.data.database.category.Category
import com.example.capstoneproject.data.database.category.CategoryRepository
import com.example.capstoneproject.data.database.food.Food
import com.example.capstoneproject.data.database.food.FoodRepository
import com.example.capstoneproject.data.database.restaurant.Restaurant
import com.example.capstoneproject.data.database.restaurant.RestaurantRepository

class CapstoneViewModel(application: Application) : ViewModel() {
    //category
    private val categoryRepo : CategoryRepository
    val categoryList: LiveData<List<Category?>>

    //restaurant
    private val restaurantRepo : RestaurantRepository
    val restaurantList: LiveData<List<Restaurant?>>

    //food
    private val foodRepo: FoodRepository
    val foodList: LiveData<List<Food>>

    init{
        val categoryDao = CapstoneDatabase.getDatabase(application).categoryDao()
        val restaurantDao = CapstoneDatabase.getDatabase(application).restaurantDao()
        val foodDao = CapstoneDatabase.getDatabase(application).foodDao()

        categoryRepo = CategoryRepository(categoryDao)
        categoryList = categoryRepo.getAllCategory().asLiveData()

        restaurantRepo = RestaurantRepository(restaurantDao)
        restaurantList = restaurantRepo.getAllRestaurant().asLiveData()

        foodRepo = FoodRepository(foodDao)
        foodList = foodRepo.getAllFood().asLiveData()
    }

    suspend fun insertCategory(category: Category)
        = categoryRepo.insertCategory(category)

    suspend fun deleteCategory(category: Category)
        = categoryRepo.deleteCategory(category)

    suspend fun insertRestaurant(restaurant: Restaurant)
    = restaurantRepo.insertRestaurant(restaurant)

    suspend fun deleteRestaurant(restaurant: Restaurant)
    = restaurantRepo.deleteRestaurant(restaurant)

    suspend fun insertFood(food: Food) = foodRepo.insertFood(food)
    suspend fun deleteFood(food:Food) = foodRepo.deleteFood(food)

}