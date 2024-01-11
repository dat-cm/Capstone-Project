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
        val restId = 1

        Scaffold{
            Column(){
                Button(
                    onClick = {
                        capstoneViewModel.viewModelScope.launch {
                            //capstoneViewModel.insertUser(User("Test User"))
                        }
                    }) {
                    Text("User")
            }
                //Button(
                //    onClick = {
                //        capstoneViewModel.viewModelScope.launch {
                //            capstoneViewModel.deleteUserById(4)
                //        }
                //    }) {
                //    Text("delete")
                //}

                Button(
                    onClick = {
                        capstoneViewModel.viewModelScope.launch {
                            //capstoneViewModel.insertRestaurant(Restaurant("The Leafy Fork", "Vegan/Vegetarian"))
                            //capstoneViewModel.deleteRestaurant(15)
                        }
                    }) {
                    Text("Add Restaurant")
                }

                Button(
                    onClick = {
                        capstoneViewModel.viewModelScope.launch {

                        }
                    }) {
                    Text("Add Food")
                }

                Button(
                    onClick = {
                        capstoneViewModel.viewModelScope.launch {
                            val listCount: List<Int> = listOf(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,
                                22,23, 24,25,26,27,28,29,30,31,32,33,34,35)
                            listCount.forEach{
                                count-> capstoneViewModel.deleteUserFav(count)
                            }

                        }
                    }) {
                    Text("Delete User fav")
                }
            }
        }
    }
}
