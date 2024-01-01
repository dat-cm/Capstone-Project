package com.example.capstoneproject.data.databasepages

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewModelScope
import coil.compose.AsyncImagePainter
import coil.compose.rememberImagePainter
import coil.decode.ImageSource
import com.example.capstoneproject.R
import com.example.capstoneproject.data.database.CapstoneViewModel
import com.example.capstoneproject.data.database.food.Food
import com.example.capstoneproject.preferences.SingleSelectCategory
import kotlinx.coroutines.launch

class ToInsertFood {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "CoroutineCreationDuringComposition")
    @Composable
    fun FoodUI(capstoneViewModel: CapstoneViewModel){
       /*val restId = 11
        capstoneViewModel.viewModelScope.launch {
            capstoneViewModel.insertFood(
                Food(
                    "Mango Coconut Chia Pudding",
                    9.99,
                    "Dessert",
"https://www.whiskaffair.com/wp-content/uploads/2021/03/Mango-Chia-Pudding-2-3-500x500.jpg",
                    restId
                ))
        }*/

        Scaffold{
            Column{
                Button(
                    onClick = {
                       // capstoneViewModel.viewModelScope.launch {
                        //    capstoneViewModel.updateFoodCategory("Fastfood", 2)
                        //}
                    }) {
                    Text("Save")
                }
            }
        }
    }
}