/*
This file is used to control the navigation between pages
 */
package com.example.capstoneproject.navigator

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.capstoneproject.data.database.CapstoneViewModel
import com.example.capstoneproject.data.database.category.Category
import com.example.capstoneproject.data.database.food.Food
import com.example.capstoneproject.data.database.restaurant.Restaurant

class PageNavigators {
    @Composable
    fun Navigation(capstoneViewModel: CapstoneViewModel){
        val navigationController = rememberNavController()
        NavHost(navController = navigationController, startDestination = "Restaurant"){
            composable(Routes.Preferences.route){
                PageComposable().ToPreferences(navigationController)
            }
            composable(Routes.Selection.route){
                PageComposable().ToSelection(navigationController)
            }
            composable(Routes.Home.route){
                PageComposable().ToHome(navigationController)
            }
            composable(Routes.Category.route){
                PageComposable().ToCategoryInsertion(capstoneViewModel)
            }
            composable(Routes.Restaurant.route){
                PageComposable().ToRestaurantInsertion(capstoneViewModel)
            }
        }
    }
}