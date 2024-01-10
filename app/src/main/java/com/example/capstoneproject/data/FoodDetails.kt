package com.example.capstoneproject.data

import com.example.capstoneproject.data.database.food.Food
import com.example.capstoneproject.data.database.restaurant.Restaurant
import com.example.capstoneproject.data.database.userpreferences.UserPreferences

var foodChoiceList: ArrayList<Food> = ArrayList()
fun createFoodProfiles(userPref: UserPreferences?, restaurant: List<Restaurant?>,
                       food: List<Food?>) {
    //reset list
    if(foodChoiceList.isNotEmpty()) foodChoiceList = ArrayList()

    restaurant.forEach{
            resItem-> if(resItem != null){
        if(resItem.restaurantCategory == userPref!!.userClassification) {
            food.forEach{
                    foodItem-> if(foodItem != null){
                if(resItem.restaurantId == foodItem.restaurantId){
                    if(userPref.userBudget >= foodItem.foodPrice ){
                        userPref.userFoodClassification.forEach{
                                item->
                            if(item == foodItem.foodCategory){
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
}
