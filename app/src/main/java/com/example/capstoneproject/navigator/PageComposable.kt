/*
This file is used to create @Composable functions to get pages to navigate
 */
package com.example.capstoneproject.navigator

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.capstoneproject.data.database.CapstoneViewModel
import com.example.capstoneproject.data.database.user.User
import com.example.capstoneproject.data.database.userpreferences.UserPreferences
import com.example.capstoneproject.selection.SelectionPageUI
import com.example.capstoneproject.preferences.PreferencesPageUI
import com.example.capstoneproject.homepage.HomePageUI
import com.example.capstoneproject.likes.LikesPageUI
import com.example.capstoneproject.recurring.RecurPageUI
import com.example.capstoneproject.data.databasepages.ToInsert


class PageComposable{
    @Composable
    fun ToHome(navController: NavHostController, user: User?){
        return HomePageUI().BuildHomePageUI(navController, user)
    }
    @Composable
    fun ToSelection(navController: NavHostController){
        return SelectionPageUI().BuildSelectionPage(navController)
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
    fun ToLike(navController: NavHostController){
        return LikesPageUI().BuildLikesUI(navController)
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