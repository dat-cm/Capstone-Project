/*
This file is used to control the navigation between pages
 */
package com.example.capstoneproject.navigator

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class PageNavigators {
    @Composable
    fun Navigation(){
        val navigationController = rememberNavController()
        NavHost(navController = navigationController, startDestination = "Category"){
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
                PageComposable().ToCategoryInsertion(navigationController)
            }
        }
    }
}