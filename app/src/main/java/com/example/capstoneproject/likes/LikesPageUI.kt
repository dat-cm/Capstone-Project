package com.example.capstoneproject.likes

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.capstoneproject.R
import com.example.capstoneproject.data.decimal.formatToTwoDecimalPlaces
import com.example.capstoneproject.navigator.Routes
import com.example.capstoneproject.ui.theme.PartyPink

class LikesPageUI {
    val foodList = listOf(
        FoodItem("Pizza", 10.00, "Mario's Pizzeria", R.drawable.pizza),
        FoodItem("Burger", 5.00, "Burger Corner", R.drawable.burger),
        FoodItem("Pasta", 8.00, "Italiano Kitchen", R.drawable.pasta),
        // Add more items as needed
    )
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun BuildLikesUI(navController: NavHostController) {
        Scaffold(
            topBar = {
            Surface(
                shadowElevation = 2.dp,
            ) {
                TopAppBar(title = { Text("My Likings") },
                    navigationIcon = {
                        IconButton(onClick = { navController.navigate(Routes.Home.route) }) {
                            Icon(
                                imageVector = Icons.Default.Close,
                                contentDescription = "Close",
                                tint = PartyPink
                            )
                        }
                    }
                )
            }
        }) {
            paddingValues->
            LazyColumn(modifier = Modifier.padding(paddingValues)) {
                items(foodList) { item ->
                    ExpandableFoodItem(foodItem = item, navController)
                }
            }
        }
    }


    @Composable
    fun ExpandableFoodItem(foodItem:FoodItem, navController: NavHostController){
        var isExpanded by remember { mutableStateOf(false) }
        ElevatedCard(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .wrapContentHeight(align = Alignment.Top),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)) {
            Row(modifier= Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start) {
                ProfilePicture(foodItem = foodItem)

                Row(modifier = Modifier.fillMaxWidth()) {
                    Column(modifier= Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                    ){
                        Row(modifier = Modifier
                            .fillMaxWidth(),
                            horizontalArrangement =
                            Arrangement.SpaceAround) {
                            Text(text = foodItem.name,
                                style = MaterialTheme.typography.headlineMedium)
                            Spacer(modifier = Modifier.width(20.dp))
                            Button(
                                onClick = { isExpanded = !isExpanded },
                                modifier = Modifier
                                    .padding(start = 8.dp)
                                    .height(32.dp)
                            ) {
                                Text(if (isExpanded) "Show Less" else "Show More")
                            }
                        }
                        Row {
                            Spacer(modifier = Modifier.width(10.dp))
                            Text(text = "$${foodItem.price.formatToTwoDecimalPlaces()}",
                                style = MaterialTheme.typography.titleMedium)
                        }
                    }
                }
            }
            if (isExpanded) {
                Spacer(modifier = Modifier.height(8.dp))

                Image(
                    painter = painterResource(id = foodItem.image),
                    contentDescription = "Food Image",
                    contentScale= ContentScale.Crop,
                    modifier = Modifier
                        .padding(16.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .height(150.dp)
                        .fillMaxWidth()
                        .border(2.dp, color = Color.Blue, shape = RoundedCornerShape(10.dp))
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(" ${foodItem.restaurant}",
                    modifier= Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.headlineSmall)
                Spacer(modifier = Modifier.height(8.dp))
                Button(
                    onClick = {
                        navController.navigate(
                            "${Routes.Recur.route}/${foodItem.name}/${foodItem.price}/${foodItem.restaurant}/${"uuuu"}"
                        )},
                    modifier= Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(16.dp)
                ) {
                    Text("Set Recurring")
                }
            }
        }
    }
    @Composable
    fun ProfilePicture(foodItem: FoodItem){
        Card(shape = CircleShape,
            border = BorderStroke(2.dp, color = Color.Blue),
            modifier = Modifier.padding(16.dp)
        ) {
            Image(painter = painterResource(id = foodItem.image ),
                contentDescription =null ,
                modifier = Modifier.size(72.dp),
                contentScale = ContentScale.Crop)
        }
    }
}