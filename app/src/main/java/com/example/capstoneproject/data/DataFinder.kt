package com.example.capstoneproject.data

import com.example.capstoneproject.data.database.food.Food
import com.example.capstoneproject.data.database.restaurant.Restaurant

fun imageDataFinder(
    id: Int,
    foodList: List<Food?>,
): String  {
    foodList.forEach {
            item ->
        if (id == item!!.foodId)
            {
                return if (item.foodImage == "") {
                    "no image"
                } else {
                    item.foodImage
                }
            }
    }
    return "no image"
}

fun foodNameDataFinder(
    id: Int,
    foodList: List<Food?>,
): String  {
    foodList.forEach {
            item ->
        if (id == item!!.foodId)
            {
                return item.foodName
            }
    }
    return ""
}

fun foodPriceDataFinder(
    id: Int,
    foodList: List<Food?>,
): Double  {
    foodList.forEach {
            item ->
        if (id == item!!.foodId)
            {
                return item.foodPrice
            }
    }

    return 0.00
}

fun restaurantNameDataFinder(
    id: Int,
    restaurant: List<Restaurant?>,
): String  {
    restaurant.forEach {
            store ->
        if (id == store!!.restaurantId)
            {
                return store.restaurantName
            }
    }
    return ""
}
