package com.example.capstoneproject.data

import android.util.Log
import com.example.capstoneproject.data.database.food.Food
import com.example.capstoneproject.data.database.restaurant.Restaurant
import com.example.capstoneproject.data.database.userpreferences.UserPreferences

var foodChoiceList: ArrayList<Food> = ArrayList()
fun createFoodProfiles(userPref: UserPreferences?, restaurant: List<Restaurant?>,
                       food: List<Food?>) {

    restaurant.forEach { resCategory ->
        if (userPref != null) {
            if (resCategory != null) {
                if(resCategory.restaurantCategory == userPref.userClassification){
                    userPref.userFoodClassification.forEach{
                            choice-> food.forEach{
                            foodChoice->
                        if(choice == foodChoice?.foodCategory){
                        foodChoiceList.add(foodChoice)
                            }
                            }
                    }
                }
            }
        }
    }
    Log.i("size", foodChoiceList.size.toString())
}