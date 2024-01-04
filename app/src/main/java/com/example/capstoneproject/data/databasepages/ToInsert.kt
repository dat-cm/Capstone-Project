package com.example.capstoneproject.data.databasepages

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewModelScope
import com.example.capstoneproject.data.database.CapstoneViewModel
import com.example.capstoneproject.data.database.food.Food
import com.example.capstoneproject.data.database.restaurant.Restaurant
import com.example.capstoneproject.data.database.user.User
import kotlinx.coroutines.launch

class ToInsert {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @Composable
    fun InsertUI(capstoneViewModel: CapstoneViewModel){
       //val restId = 11


        Scaffold{
            Column(){
                Button(
                    onClick = {
                        capstoneViewModel.viewModelScope.launch {
                            capstoneViewModel.insertUser(User("Test User"))
                        }
                    }) {
                    Text("User")
            }
                Button(
                    onClick = {
                        capstoneViewModel.viewModelScope.launch {
                            capstoneViewModel.deleteUserById(4)
                        }
                    }) {
                    Text("delete")
                }

                Button(
                    onClick = {
                        capstoneViewModel.viewModelScope.launch {
                            capstoneViewModel.insertRestaurant(Restaurant("Halal Haven","Halal"))
                        }
                    }) {
                    Text("Add Restaurant")
                }

                Button(
                    onClick = {
                        capstoneViewModel.viewModelScope.launch {
                            capstoneViewModel.insertFood(Food("Noodle2",13.00,"Noodles","",1))
                        }
                    }) {
                    Text("Add Food")
                }
            }
        }
    }
}