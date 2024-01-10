package com.example.capstoneproject.likes

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.capstoneproject.data.database.food.Food
import com.example.capstoneproject.data.database.restaurant.Restaurant
import com.example.capstoneproject.data.database.userfavourite.UserFavourite
import com.example.capstoneproject.data.decimal.formatToTwoDecimalPlaces
import com.example.capstoneproject.navigator.Routes
import com.example.capstoneproject.ui.theme.PartyPink

class LikesPageUI {
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun BuildLikesUI(navController: NavHostController, restaurant: List<Restaurant?>, userFav:
    List<UserFavourite?>, foodList: List<Food?>) {
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
            LazyColumn(
                modifier = Modifier.padding(paddingValues)) {
                items(userFav) {
                        item -> ExpandableFoodItem(item,  navController, restaurant, foodList)
                }
            }
        }
    }


    @Composable
    fun ExpandableFoodItem(userFav: UserFavourite?, navController: NavHostController, restaurant:
    List<Restaurant?>,
                           foodList: List<Food?>){
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
                ProfilePicture(userFav, foodList)

                Row(modifier = Modifier.fillMaxWidth()) {
                    Column(modifier= Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                    ){
                        Row(modifier = Modifier
                            .fillMaxWidth(),
                            horizontalArrangement =
                            Arrangement.SpaceAround) {
                            Text(text = retrieveFoodName(userFav!!.foodId, foodList),
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
                            Text(text = "$${retrieveFoodPrice(userFav!!.foodId, foodList).formatToTwoDecimalPlaces()}",
                                style = MaterialTheme.typography.titleMedium)
                        }
                    }
                }
            }
            if (isExpanded) {
                Spacer(modifier = Modifier.height(8.dp))

                ProfilePicture(userFav, foodList)

                /*AsyncImage(
                    model = foodItem.foodImage,
                    contentDescription = "Food Image",
                    contentScale= ContentScale.Crop,
                    modifier = Modifier
                        .padding(16.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .height(150.dp)
                        .fillMaxWidth()
                        .border(2.dp, color = Color.Blue, shape = RoundedCornerShape(10.dp))
                )*/
                Spacer(modifier = Modifier.height(8.dp))
                Text(" ${retrieveRestaurantName(userFav!!.restaurantId, restaurant)}",
                    modifier= Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.headlineSmall)
                Spacer(modifier = Modifier.height(8.dp))
                Button(
                    onClick = {
                        navController.navigate(
                            "${Routes.Recur.route}/" +
                            "${retrieveFoodName(userFav.foodId, foodList)}/" +
                                "${retrieveFoodPrice(userFav.foodId,foodList)}/" +
                                "${retrieveRestaurantName(userFav.restaurantId, restaurant)}/" +
                                retrieveImage(userFav.foodId, foodList)
                                //"${retrieveFoodName(userFav.foodId, foodList)}/" +
                                //"${retrieveFoodPrice(userFav.foodId,foodList)}/" +
                                //"${retrieveRestaurantName(userFav.restaurantId, restaurant)}/" +
                                //retrieveImage(userFav.foodId, foodList)
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
    fun ProfilePicture(userFav: UserFavourite?, foodList: List<Food?>){
        var imageUrl: String
        Card(shape = CircleShape,
            border = BorderStroke(2.dp, color = Color.Blue),
            modifier = Modifier.padding(16.dp)
        ) {
            imageUrl = retrieveImage(userFav!!.foodId, foodList)
                AsyncImage(model = imageUrl, contentDescription = null)
            }
        }
    }

    private fun retrieveImage(id: Int, foodList:List<Food?>): String{
    foodList.forEach{
                item-> if(id == item!!.foodId){
        return if(item.foodImage == "") "no image" else item.foodImage
                }
        }
        return ""
    }

    private fun retrieveFoodName(id: Int, foodList:List<Food?>): String{
    foodList.forEach{
                item-> if (id == item!!.foodId){
            return item.foodName
                }
        }
        return ""
    }

    private fun retrieveFoodPrice(id: Int, foodList: List<Food?>): Double{
        foodList.forEach{
                item-> if (id == item!!.foodId){
            return item.foodPrice
            }
        }

        return 0.00
    }

    private fun retrieveRestaurantName(id: Int, restaurant: List<Restaurant?>) : String{
        restaurant.forEach{
                store -> if(id == store!!.restaurantId){
            return store.restaurantName
            }
        }
        return ""
    }
