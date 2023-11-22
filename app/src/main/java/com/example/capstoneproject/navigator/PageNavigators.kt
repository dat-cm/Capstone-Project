package com.example.capstoneproject.navigator

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.capstoneproject.add.AddPageUI
import com.example.capstoneproject.display.DisplayPageUI
import com.example.capstoneproject.edit.EditPageUI

class PageNavigators {
    @Composable
    fun Navigation(){
        val navigationController = rememberNavController()
        NavHost(navController = navigationController, startDestination = "Display"){
            composable(Routes.Add.route){
                PageComposables().ToAdd(navigationController)
            }
            composable(Routes.Display.route){
                PageComposables().ToDisplay(navigationController)
            }
            composable(Routes.Edit.route){
                PageComposables().ToEdit(navigationController)
            }
        }
    }
}