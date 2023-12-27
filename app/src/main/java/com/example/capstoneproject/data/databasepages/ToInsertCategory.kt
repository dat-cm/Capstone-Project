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
import androidx.navigation.NavController

class ToInsertCategory {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun CategoryUI(navController: NavController){
        var categoryName by remember { mutableStateOf("") }
        Scaffold{
            Column{
                TextField(
                    value = categoryName,
                    onValueChange = {categoryName=it}
                )
                Button(onClick = { /*TODO*/ }) {
                    Text("Save")
                }
            }
        }
    }
}