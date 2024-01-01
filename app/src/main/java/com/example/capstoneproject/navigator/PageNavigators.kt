/*
This file is used to control the navigation between pages
 */
package com.example.capstoneproject.navigator

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.capstoneproject.data.database.CapstoneViewModel

class PageNavigators {
    @Composable
    fun Navigation(capstoneViewModel: CapstoneViewModel){
        val navigationController = rememberNavController()
        NavHost(navController = navigationController,
            startDestination = "Like"){
            composable(Routes.Preferences.route){
                PageComposable().ToPreferences(navigationController)
            }
            composable(Routes.Selection.route){
                PageComposable().ToSelection(navigationController)
            }
            composable(Routes.Home.route){
                PageComposable().ToHome(navigationController)
            }
            composable(Routes.Like.route){
                PageComposable().ToLike(navigationController)
            }
            composable("${Routes.Recur.route}/{foodName}/{foodPrice}/{restaurant}/{image}",
                arguments = listOf(
                    navArgument("foodName"){type = NavType.StringType},
                    navArgument("foodPrice"){type = NavType.FloatType},
                    navArgument("restaurant"){type = NavType.StringType},
                    navArgument("image"){type = NavType.StringType},

                )){
                backstackEntry->
                val foodName = backstackEntry.arguments?.getString("foodName")
                val foodPrice = backstackEntry.arguments?.getFloat("foodPrice")?.toDouble()
                val restaurant = backstackEntry.arguments?.getString("restaurant")
                val image = backstackEntry.arguments?.getString("image")

                PageComposable().ToRecur(navigationController, foodName,foodPrice, restaurant, image
            )

            }
            /*composable(Routes.Category.route){
                PageComposable().ToCategoryInsertion(capstoneViewModel)
            }
            composable(Routes.Restaurant.route){
                PageComposable().ToRestaurantInsertion(capstoneViewModel)
            }
            composable(Routes.Food.route) {
                PageComposable().ToFoodInsertion(capstoneViewModel)
            }*/
           // composable(Routes.User.route) {
           //     PageComposable().ToUserInsertion(capstoneViewModel)
           // }
        }
    }
}