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
import com.example.capstoneproject.data.database.user.User
import kotlinx.coroutines.launch

class ToInsert {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "CoroutineCreationDuringComposition")
    @Composable
    fun InsertUI(capstoneViewModel: CapstoneViewModel){
       //val restId = 11
        /*capstoneViewModel.viewModelScope.launch {
            capstoneViewModel.insertUser(User("Test User"))
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