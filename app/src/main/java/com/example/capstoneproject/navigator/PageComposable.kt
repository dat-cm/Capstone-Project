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
import com.example.capstoneproject.selection.SelectionPageUI
import com.example.capstoneproject.preferences.PreferencesPageUI
import com.example.capstoneproject.likes.LikesPageUI
import com.example.capstoneproject.recurring.RecurPageUI
import com.example.capstoneproject.data.databasepages.ToInsert
import com.example.capstoneproject.homepage.HomeUI


class PageComposable{
    @Composable
    fun ToHome(navController: NavHostController, user: User?,
               userPref: UserPreferences?, restaurantList: List<Restaurant?>, foodList: List<Food?>){
        return HomeUI(navController, user, userPref,
            restaurantList, foodList)
    }
    @Composable
    fun ToSelection(navController: NavHostController, capstoneViewModel: CapstoneViewModel, user: User?){
        return SelectionPageUI().BuildSelectionPage(navController, capstoneViewModel, user)
    }
    @Composable
    fun ToPreferences(
        navController: NavHostController,
        capstoneViewModel: CapstoneViewModel, user: User?, userPref: UserPreferences?
    ){
        return PreferencesPageUI().BuildPreferencesUI(navController,
            capstoneViewModel, user, userPref)
    }

    @Composable
    fun ToLike(navController: NavHostController, restaurantList: List<Restaurant?>, userFav: List<UserFavourite?>,
               foodList: List<Food?>){
        return LikesPageUI().BuildLikesUI(navController, restaurantList, userFav, foodList)
    }

    @Composable
    fun ToRecur(
        navController: NavHostController, foodName: String?, foodPrice: Double?,
        restaurant: String?, image: String?){
        return RecurPageUI().BuildRecurUI(navController, foodName, foodPrice,
            restaurant, image)
    }

    @Composable
    fun ToInsert(capstoneViewModel: CapstoneViewModel){
        return ToInsert().InsertUI(capstoneViewModel)
    }
}
