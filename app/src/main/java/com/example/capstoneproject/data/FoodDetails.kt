package com.example.capstoneproject.data

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.capstoneproject.data.database.food.Food
import com.example.capstoneproject.data.database.restaurant.Restaurant
import com.example.capstoneproject.data.database.userfavourite.UserFavourite
import com.example.capstoneproject.data.database.userpreferences.UserPreferences

var foodChoiceList: ArrayList<Food> = ArrayList()

@RequiresApi(Build.VERSION_CODES.N)
fun createFoodProfiles(
    userPref: UserPreferences?,
    restaurant: List<Restaurant?>,
    food: List<Food?>,
    userFav: List<UserFavourite?>,
) {
    // reset list
    if (foodChoiceList.isNotEmpty()) foodChoiceList = ArrayList()

    restaurant.forEach {
            resItem ->
        if (resItem != null) {
            if (resItem.restaurantCategory == userPref!!.userClassification) {
                food.forEach {
                        foodItem ->
                    if (foodItem != null) {
                        if (resItem.restaurantId == foodItem.restaurantId) {
                            if (userPref.userBudget >= foodItem.foodPrice) {
                                userPref.userFoodClassification.forEach {
                                        item ->
                                    if (item == foodItem.foodCategory) {
                                        foodChoiceList.add(foodItem)
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    if (userFav.isNotEmpty())
        {
            foodChoiceList = removeUserFavFromSelection(foodChoiceList, userFav)
        }
}

@RequiresApi(Build.VERSION_CODES.N)
fun removeUserFavFromSelection(
    choiceList: List<Food>,
    userFav: List<UserFavourite?>,
): ArrayList<Food> {
    val updatedList = ArrayList(choiceList) // Create a new ArrayList to hold the updated items

    // Use removeIf to remove items that match the condition
    updatedList.removeIf { foodItem ->
        userFav.any { favItem ->
            favItem?.foodId == foodItem.foodId
        }
    }

    return updatedList
}
