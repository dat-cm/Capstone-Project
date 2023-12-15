/*
This file is used to store Routes and their naming for easy access
 */
package com.example.capstoneproject.navigator

sealed class Routes  (val route: String){
    object Home: Routes("Home")
    object Display : Routes("Display")
    object Add : Routes("Create")
    object Edit : Routes("Edit")
}