package com.example.capstoneproject.data.databasepages

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import com.example.capstoneproject.data.database.CapstoneViewModel
import com.example.capstoneproject.data.database.category.Category
import com.example.capstoneproject.data.database.restaurant.Restaurant
import com.example.capstoneproject.preferences.SingleSelect
import kotlinx.coroutines.launch

class ToInsertRestaurant {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun RestaurantUI(capstoneViewModel: CapstoneViewModel){
        var restaurantName by remember { mutableStateOf("") }
        var restaurantType by remember { mutableStateOf("") }
        Scaffold{
            Column{
                TextField(
                    value = restaurantName,
                    onValueChange = {restaurantName=it},
                    label = { Text(text = "Name")}
                )
                restaurantType = SingleSelect()
                Button(
                    enabled = !(restaurantName == "" && restaurantType == ""),
                    onClick = {
                        capstoneViewModel.viewModelScope.launch {
                            capstoneViewModel.insertRestaurant(Restaurant(restaurantName, restaurantType))
                            restaurantName = ""
                            restaurantType = ""
                        }
                    }) {
                    Text("Save")
                }
            }
        }
    }
}