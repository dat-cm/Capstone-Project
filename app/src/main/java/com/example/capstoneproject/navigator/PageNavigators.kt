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
        NavHost(navController = navigationController, startDestination = "Home"){
            composable(Routes.Add.route){
                PageComposable().ToAdd(navigationController)
            }
            composable(Routes.Display.route){
                PageComposable().ToDisplay(navigationController)
            }
            composable(Routes.Edit.route){
                PageComposable().ToEdit(navigationController)
            }
            composable(Routes.Home.route){
                PageComposable().ToHome(navigationController)
            }
        }
    }
}