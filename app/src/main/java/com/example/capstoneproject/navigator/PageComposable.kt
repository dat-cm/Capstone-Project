/*
This file is used to create @Composable functions to get pages to navigate
 */
package com.example.capstoneproject.navigator

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.capstoneproject.add.AddPageUI
import com.example.capstoneproject.display.DisplayPageUI
import com.example.capstoneproject.edit.EditPageUI

class PageComposable
{
    @Composable
    fun ToDisplay(navController: NavHostController){
        return DisplayPageUI().BuildDisplayPage(navController)
    }
    @Composable
    fun ToAdd(navController: NavHostController){
        return AddPageUI().BuildAddPage(navController)
    }
    @Composable
    fun ToEdit(navController: NavHostController){
        return EditPageUI().BuildEditPage(navController)
    }

}