package com.example.capstoneproject.data
data class FoodDetails(
    val foodName: String,
    val foodId: String = "",
    val cost: Double,
    val foodImage: String)

//temp list input from firebase
val foodProfiles = listOf(
    FoodDetails("Burger","",4.4, ""),
    FoodDetails("Rice","",5.0, ""),
    FoodDetails("Noodle","",4.6, "")
)