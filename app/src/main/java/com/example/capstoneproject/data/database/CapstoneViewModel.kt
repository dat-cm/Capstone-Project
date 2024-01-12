package com.example.capstoneproject.data.database

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.capstoneproject.data.database.food.Food
import com.example.capstoneproject.data.database.food.FoodRepository
import com.example.capstoneproject.data.database.restaurant.Restaurant
import com.example.capstoneproject.data.database.restaurant.RestaurantRepository
import com.example.capstoneproject.data.database.user.User
import com.example.capstoneproject.data.database.user.UserRepository
import com.example.capstoneproject.data.database.userfavourite.UserFavourite
import com.example.capstoneproject.data.database.userfavourite.UserFavouriteRepository
import com.example.capstoneproject.data.database.userpreferences.UserPreferences
import com.example.capstoneproject.data.database.userpreferences.UserPreferencesRepository

class CapstoneViewModel(application: Application) : ViewModel() {
    // category
    // private val categoryRepo : CategoryRepository
    // val categoryList: LiveData<List<Category?>>

    // restaurant
    private val restaurantRepo: RestaurantRepository
    val restaurantList: LiveData<List<Restaurant?>>

    // food
    private val foodRepo: FoodRepository
    val foodList: LiveData<List<Food>>

    // user
    private val userRepo: UserRepository

    // val allUser: LiveData<List<User>>
    val user: LiveData<User>

    // user preferences
    private val userPrefRepo: UserPreferencesRepository
    val userPrefList: LiveData<UserPreferences>

    // user fav
    private val userFavRepo: UserFavouriteRepository
    val userFavList: LiveData<List<UserFavourite>>

    init {
        // val categoryDao = CapstoneDatabase.getDatabase(application).categoryDao()
        val restaurantDao = CapstoneDatabase.getDatabase(application).restaurantDao()
        val foodDao = CapstoneDatabase.getDatabase(application).foodDao()
        val userDao = CapstoneDatabase.getDatabase(application).userDao()
        val userPrefDao = CapstoneDatabase.getDatabase(application).userPreferencesDao()
        val userFavDao = CapstoneDatabase.getDatabase(application).userFavouriteDao()

        // categoryRepo = CategoryRepository(categoryDao)
        // categoryList = categoryRepo.getAllCategory().asLiveData()

        restaurantRepo = RestaurantRepository(restaurantDao)
        restaurantList = restaurantRepo.getAllRestaurant().asLiveData()

        foodRepo = FoodRepository(foodDao)
        foodList = foodRepo.getAllFood().asLiveData()

        userRepo = UserRepository(userDao)
        // allUser = userRepo.getAllUser().asLiveData()
        user = userRepo.getSpecificUser(1).asLiveData()

        userPrefRepo = UserPreferencesRepository(userPrefDao)
        userPrefList = userPrefRepo.getAllUserPreferences(1).asLiveData()

        userFavRepo = UserFavouriteRepository(userFavDao)
        userFavList = userFavRepo.getSpecificUserFav(1).asLiveData()
    }

    // category
    /*suspend fun insertCategory(category: Category)
        = categoryRepo.insertCategory(category)
    suspend fun deleteCategory(categoryId: Int)
        = categoryRepo.deleteCategory(categoryId)*/

    // restaurant
    suspend fun insertRestaurant(restaurant: Restaurant) = restaurantRepo.insertRestaurant(restaurant)

    suspend fun deleteRestaurant(restaurantId: Int) = restaurantRepo.deleteRestaurant(restaurantId)

    // food
    suspend fun insertFood(food: Food) = foodRepo.insertFood(food)

    suspend fun deleteFood(id: Int) = foodRepo.deleteFood(id)

    suspend fun updateFoodImage(
        image: String,
        foodId: Int,
    ) = foodRepo.updateFoodImage(image, foodId)
    // suspend fun updateFoodCategory(category: String, foodId: Int)
    //   = foodRepo.updateFoodCategory(category, foodId)

    // user
    suspend fun insertUser(user: User) = userRepo.insertUser(user)

    suspend fun deleteUserById(userId: Int) = userRepo.deleteUserById(userId)

    suspend fun updateUserName(userName: String) = userRepo.updateUserName(userName)

    suspend fun updateUserPref(pref: Boolean) = userRepo.updateUserPref(pref)

    // user pref
    suspend fun insertUserPref(userPref: UserPreferences) = userPrefRepo.insertUserPreferences(userPref)

    suspend fun updateUserClassification(userClassification: String) = userPrefRepo.updateUserClassification(userClassification)

    suspend fun updateUserFoodClassification(userFoodClassification: List<String>) =
        userPrefRepo.updateUserFoodClassification(
            userFoodClassification,
        )

    suspend fun updateUserBudget(userBudget: Double) = userPrefRepo.updateUserBudget(userBudget)

    suspend fun updateAllUserPreferences(userPreferences: UserPreferences) = userPrefRepo.updateAllUserPref(userPreferences)

    // user fav
    suspend fun insertUserFav(userFavourite: UserFavourite) = userFavRepo.insertUserFavourites(userFavourite)

    suspend fun deleteUserFav(favId: Int) = userFavRepo.deleteUserFavourites(favId)

    suspend fun updateRecurrence(
        id: Int,
        recur: Boolean,
        recurTime: String,
        recurDay: List<String>,
    ) = userFavRepo.updateRecurrence(
        id,
        recur,
        recurTime,
        recurDay,
    )
}
