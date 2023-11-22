package com.example.capstoneproject.navigator

import androidx.navigation.Navigation

sealed class Routes  (val route: String){
    object Display : Routes("Display")
    object Add : Routes("Create")
    object Edit : Routes("Edit")
}