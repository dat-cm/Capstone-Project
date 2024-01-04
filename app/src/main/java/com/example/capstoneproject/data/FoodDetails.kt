package com.example.capstoneproject.data

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.capstoneproject.data.database.CapstoneViewModel
import com.example.capstoneproject.data.database.food.Food
import com.example.capstoneproject.data.database.restaurant.Restaurant
import com.example.capstoneproject.data.database.userpreferences.UserPreferences
import kotlinx.coroutines.launch

var foodList: ArrayList<Food> = ArrayList()
var restaurantList: ArrayList<Int> = ArrayList()
fun createFoodProfiles(userPref: UserPreferences?, restaurant: List<Restaurant?>,
                       food: List<Food?>,
                       capstoneViewModel: CapstoneViewModel) {

        restaurant.forEach { item ->
            if (userPref != null) {
                if (item != null) {
                    if(item.restaurantCategory == userPref.userClassification){
                        restaurantList.add(item.restaurantId)
                        Log.i("restaurant", item.restaurantName)
                    }
                }
            }
            food.forEach{items->
                userPref?.userFoodClassification?.forEach{ foodclass->
                    if (items != null) {
                        if (item != null) {
                            if(items.foodCategory == foodclass && items.restaurantId == item.restaurantId){
                                foodList.add(items)
                                Log.i("food", items.foodName)
                            }
                        }
                    }
                }
        }

    }
}