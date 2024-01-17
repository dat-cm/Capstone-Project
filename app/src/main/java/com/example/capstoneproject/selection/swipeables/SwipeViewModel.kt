package com.example.capstoneproject.selection.swipeables

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.capstoneproject.data.database.CapstoneViewModel
import com.example.capstoneproject.data.database.food.Food
import com.example.capstoneproject.data.database.user.User
import com.example.capstoneproject.data.database.userfavourite.UserFavourite
import kotlinx.coroutines.launch

class SwipeViewModel(private val capstoneViewModel: CapstoneViewModel) : ViewModel() {
    fun saveSwipeCard(
        user: User?,
        food: Food?,
    )  {
        viewModelScope.launch {
            if (user != null && food != null) {
                capstoneViewModel.insertUserFav(
                    UserFavourite(
                        user.userId,
                        food.restaurantId,
                        food.foodId,
                    ),
                )
            }
        }
    }
}
