/*
This file is used to store Routes and their naming for easy access
 */
package com.example.capstoneproject.navigator

sealed class Routes  (val route: String){
    object Home: Routes("Home")
    object Selection : Routes("Selection")
    object Preferences : Routes("Preferences")
   // object Category: Routes("Category")
    //object Restaurant: Routes("Restaurant")
    //object Food: Routes("Food")
   //object User: Routes("User")
    object Like: Routes("Like")
    object Recur: Routes("Recur")
}