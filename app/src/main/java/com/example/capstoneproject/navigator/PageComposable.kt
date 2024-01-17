/*
This file is used to create @Composable functions to get pages to navigate
 */
package com.example.capstoneproject.navigator

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.capstoneproject.data.database.CapstoneViewModel
import com.example.capstoneproject.data.database.food.Food
import com.example.capstoneproject.data.database.restaurant.Restaurant
import com.example.capstoneproject.data.database.user.User
import com.example.capstoneproject.data.database.userfavourite.UserFavourite
import com.example.capstoneproject.data.database.userpreferences.UserPreferences
import com.example.capstoneproject.data.databasepages.ToInsert
import com.example.capstoneproject.favourite.FavouriteUI
import com.example.capstoneproject.homepage.HomeUI
import com.example.capstoneproject.preferences.PreferencesUI
import com.example.capstoneproject.recurring.RecurringUI
import com.example.capstoneproject.selection.SelectionUI

@Suppress("ktlint:standard:function-naming")
class PageComposable {
    @Composable
    fun ToHome(
        navController: NavHostController,
        user: User?,
        userPref: UserPreferences?,
        restaurantList: List<Restaurant?>,
        foodList: List<Food?>,
    ) {
        return HomeUI(
            navController,
            user,
            userPref,
            restaurantList,
            foodList,
        )
    }

    @Composable
    fun ToSelection(
        navController: NavHostController,
        capstoneViewModel: CapstoneViewModel,
        user: User?,
        userPref: UserPreferences?,
        restaurantList: List<Restaurant?>,
        foodList: List<Food?>,
        userFav: List<UserFavourite?>,
    ) {
        return SelectionUI(
            navController,
            capstoneViewModel,
            user,
            userPref,
            restaurantList,
            foodList,
            userFav,
        )
    }

    @Composable
    fun ToPreferences(
        navController: NavHostController,
        capstoneViewModel: CapstoneViewModel,
        user: User?,
        userPref: UserPreferences?,
    ) {
        return PreferencesUI(
            navController,
            capstoneViewModel,
            user,
            userPref,
        )
    }

    @Composable
    fun ToLike(
        navController: NavHostController,
        restaurantList: List<Restaurant?>,
        userFav: List<UserFavourite?>,
        foodList: List<Food?>,
    ) {
        return FavouriteUI(navController, restaurantList, userFav, foodList)
    }

    @Composable
    fun ToRecur(
        capstoneViewModel: CapstoneViewModel,
        navController: NavHostController,
        foodName: String?,
        foodPrice: Double?,
        restaurant: String?,
        image: String?,
        favId: Int?,
    ) {
        return RecurringUI(
            capstoneViewModel,
            navController,
            foodName,
            foodPrice,
            restaurant,
            image,
            favId,
        )
    }

    @Composable
    fun ToInsert(capstoneViewModel: CapstoneViewModel) {
        return ToInsert().InsertUI(capstoneViewModel)
    }
}
