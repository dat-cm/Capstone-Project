/*
This file is used to create @Composable functions to get pages to navigate
 */
package com.example.capstoneproject.navigator

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.capstoneproject.data.database.CapstoneViewModel
import com.example.capstoneproject.selection.SelectionPageUI
import com.example.capstoneproject.preferences.PreferencesPageUI
import com.example.capstoneproject.homepage.HomePageUI
import com.example.capstoneproject.data.databasepages.ToInsertCategory
import com.example.capstoneproject.data.databasepages.ToInsertRestaurant

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
    fun ToCategoryInsertion(capstoneViewModel: CapstoneViewModel){
        return ToInsertCategory().CategoryUI(capstoneViewModel)
    }

    @Composable
    fun ToRestaurantInsertion(capstoneViewModel: CapstoneViewModel){
        return ToInsertRestaurant().RestaurantUI(capstoneViewModel)
    }

}