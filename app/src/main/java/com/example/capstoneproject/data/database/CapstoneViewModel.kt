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
import com.example.capstoneproject.data.database.user.User
import com.example.capstoneproject.data.database.user.UserRepository
import com.example.capstoneproject.data.database.userpreferences.UserPreferences
import com.example.capstoneproject.data.database.userpreferences.UserPreferencesRepository

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

    //user
    //private val userRepo: UserRepository
    //private val user: LiveData<User>

    //user preferences
    //private val userPrefRepo: UserPreferencesRepository
    //val userPrefList: LiveData<List<UserPreferences>>

    init{
        val categoryDao = CapstoneDatabase.getDatabase(application).categoryDao()
        val restaurantDao = CapstoneDatabase.getDatabase(application).restaurantDao()
        val foodDao = CapstoneDatabase.getDatabase(application).foodDao()
        //val userDao = CapstoneDatabase.getDatabase(application).userDao()
        //val userPrefDao = CapstoneDatabase.getDatabase(application).userPreferencesDao()

        categoryRepo = CategoryRepository(categoryDao)
        categoryList = categoryRepo.getAllCategory().asLiveData()

        restaurantRepo = RestaurantRepository(restaurantDao)
        restaurantList = restaurantRepo.getAllRestaurant().asLiveData()

        foodRepo = FoodRepository(foodDao)
        foodList = foodRepo.getAllFood().asLiveData()

        //userRepo = UserRepository(userDao)
        //user = userRepo.getSpecificUser("user").asLiveData()

        //userPrefRepo = UserPreferencesRepository(userPrefDao)
        //userPrefList = user.value?.let { userPrefRepo.getAllUserPreferences(it.userId).asLiveData() }!!
    }

    suspend fun insertCategory(category: Category)
        = categoryRepo.insertCategory(category)

    suspend fun deleteCategory(categoryId: Int)
        = categoryRepo.deleteCategory(categoryId)

    suspend fun insertRestaurant(restaurant: Restaurant)
    = restaurantRepo.insertRestaurant(restaurant)

    suspend fun deleteRestaurant(restaurantId: Int)
    = restaurantRepo.deleteRestaurant(restaurantId)

    suspend fun insertFood(food: Food) = foodRepo.insertFood(food)
    suspend fun deleteFood(id:Int) = foodRepo.deleteFood(id)
    suspend fun updateFoodImage(image: String, foodId: Int)
    = foodRepo.updateFoodImage(image, foodId)
    suspend fun updateFoodCategory(category: String, foodId: Int)
        = foodRepo.updateFoodCategory(category, foodId)



    //suspend fun insertUser(user: User) = userRepo.insertUser(user)
    //suspend fun deleteUser(user:User) = userRepo.deleteUser(user)

    //suspend fun insertUserPref(userPref: UserPreferences)
    //= userPrefRepo.insertUserPreferences(userPref)

    //suspend fun deleteUserPref(userPref: UserPreferences)
    //= userPrefRepo.deleteUserPreferences(userPref)
}