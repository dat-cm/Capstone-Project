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
import com.example.capstoneproject.data.database.food.Food
import com.example.capstoneproject.data.database.restaurant.Restaurant
import com.example.capstoneproject.data.database.user.User
import com.example.capstoneproject.data.database.userfavourite.UserFavourite
import com.example.capstoneproject.data.database.userpreferences.UserPreferences

class PageNavigators {
    @Suppress("ktlint:standard:function-naming")
    @Composable
    fun Navigation(
        capstoneViewModel: CapstoneViewModel,
        user: User?,
        userPref: UserPreferences?,
        restaurantList: List<Restaurant?>,
        foodList: List<Food?>,
        userFav: List<UserFavourite?>,
    ) {
        val navigationController = rememberNavController()
        NavHost(
            navController = navigationController,
            startDestination = Routes.Home.route,
        ) {
            composable(Routes.Preferences.route) {
                PageComposable().ToPreferences(
                    navigationController,
                    capstoneViewModel,
                    user,
                    userPref,
                )
            }
            composable(Routes.Selection.route) {
                PageComposable().ToSelection(
                    navigationController,
                    capstoneViewModel,
                    user,
                    userPref,
                    restaurantList,
                    foodList,
                )
            }
            composable(Routes.Home.route) {
                PageComposable().ToHome(
                    navigationController,
                    user,
                    userPref,
                    restaurantList,
                    foodList,
                )
            }
            composable(Routes.Like.route) {
                PageComposable().ToLike(
                    navigationController,
                    restaurantList,
                    userFav,
                    foodList,
                )
            }
            composable(
                "${Routes.Recur.route}/{foodName}/" +
                    "{foodPrice}/{restaurant}/{image}/{favId}",
                arguments =
                    listOf(
                        navArgument("foodName") { type = NavType.StringType },
                        navArgument("foodPrice") { type = NavType.FloatType },
                        navArgument("restaurant") { type = NavType.StringType },
                        navArgument("image") { type = NavType.StringType },
                        navArgument("favId") { type = NavType.IntType },
                    ),
            ) {
                    backstackEntry ->
                val foodName = backstackEntry.arguments?.getString("foodName")
                val foodPrice = backstackEntry.arguments?.getFloat("foodPrice")?.toDouble()
                val restaurant = backstackEntry.arguments?.getString("restaurant")
                val image = backstackEntry.arguments?.getString("image") ?: ""
                val favId = backstackEntry.arguments?.getInt("favId")

                PageComposable().ToRecur(
                    capstoneViewModel,
                    navigationController,
                    foodName,
                    foodPrice,
                    restaurant,
                    image,
                    favId,
                )
            }
            composable(Routes.Insert.route) {
                PageComposable().ToInsert(capstoneViewModel)
            }
        }
    }
}
