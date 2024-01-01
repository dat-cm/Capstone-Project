/*
This file is used to create @Composable functions to get pages to navigate
 */
package com.example.capstoneproject.navigator

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.capstoneproject.selection.SelectionPageUI
import com.example.capstoneproject.preferences.PreferencesPageUI
import com.example.capstoneproject.homepage.HomePageUI
import com.example.capstoneproject.likes.LikesPageUI
import com.example.capstoneproject.recurring.RecurPageUI

class PageComposable{
    @Composable
    fun ToHome(navController: NavHostController){
        return HomePageUI().BuildHomePageUI(navController)
    }
    @Composable
    fun ToSelection(navController: NavHostController){
        return SelectionPageUI().BuildSelectionPage(navController)
    }
    @Composable
    fun ToPreferences(navController: NavHostController){
        return PreferencesPageUI().BuildPreferencesUI(navController)
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

    /*@Composable
    fun ToCategoryInsertion(capstoneViewModel: CapstoneViewModel){
        return ToInsertCategory().CategoryUI(capstoneViewModel)
    }

    @Composable
    fun ToRestaurantInsertion(capstoneViewModel: CapstoneViewModel){
        return ToInsertRestaurant().RestaurantUI(capstoneViewModel)
    }

    @Composable
    fun ToFoodInsertion(capstoneViewModel: CapstoneViewModel){
        return ToInsertFood().FoodUI(capstoneViewModel)
    }*/

    //@Composable
    //fun ToUserInsertion(capstoneViewModel: CapstoneViewModel){
    //    return ToInsertUser().UserUI(capstoneViewModel)
    //}
}