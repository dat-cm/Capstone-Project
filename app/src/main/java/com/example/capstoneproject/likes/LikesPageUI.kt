package com.example.capstoneproject.likes

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.capstoneproject.data.database.food.Food
import com.example.capstoneproject.data.database.restaurant.Restaurant
import com.example.capstoneproject.data.database.userfavourite.UserFavourite
import com.example.capstoneproject.data.decimal.formatToTwoDecimalPlaces
import com.example.capstoneproject.navigator.Routes
import com.example.capstoneproject.ui.theme.CoolGrey
import com.example.capstoneproject.ui.theme.PartyPink
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

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
            if(userFav.isNotEmpty()) {
                LazyColumn(
                    modifier = Modifier.padding(paddingValues)
                ) {
                    items(userFav) { item ->
                        ExpandableFoodItem(item, navController, restaurant, foodList)
                    }
                }
            }else{
                Column(
                    modifier = Modifier
                        .padding(
                            start = 16.dp,
                            end = 16.dp
                        )
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text("Head over to Food Subscription to start liking your Food",
                        fontSize = 24.sp,
                        textAlign = TextAlign.Center)
                    Button(onClick = {navController.navigate(Routes.Selection.route)},
                        colors = ButtonDefaults.buttonColors(PartyPink)){
                        Text("Go")
                    }
                }
            }
        }
    }


    @Composable
    fun ExpandableFoodItem(
        userFav: UserFavourite?,
        navController: NavHostController, restaurant:
        List<Restaurant?>,
        foodList: List<Food?>){
        var isExpanded by remember { mutableStateOf(false) }
        ElevatedCard(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
                .wrapContentHeight(align = Alignment.Top),
            colors = CardDefaults.cardColors(CoolGrey),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)) {
            if(!isExpanded) {
                UnexpandedCard(isExpanded,userFav, foodList, onItemClick = {isExpanded = it})
            } else{
                ExpandedCard(navController,restaurant, userFav, foodList, onItemClick = {isExpanded = it}, isExpanded)
            }
        }
    }

    @Composable
    fun UnexpandedCard(
        isExpanded: Boolean,
        userFav: UserFavourite?,
        foodList: List<Food?>,
        onItemClick: (Boolean) -> Unit){
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start) {
            ProfilePictureUnexpanded(userFav, foodList)
            Column {
                Text(text = retrieveFoodName(userFav!!.foodId, foodList),
                    style = MaterialTheme.typography.headlineSmall)
                Text(text = "$${retrieveFoodPrice(userFav.foodId, foodList).formatToTwoDecimalPlaces()}",
                    style = MaterialTheme.typography.titleMedium)
            }
                Icon(
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .clickable {
                            onItemClick(!isExpanded)
                        },
                    imageVector = Icons.Default.KeyboardArrowDown,
                    contentDescription = "Arrow Down" )
        }
    }

    @Composable
    fun ExpandedCard(
        navController: NavHostController,
        restaurant: List<Restaurant?>,
        userFav: UserFavourite?,
        foodList: List<Food?>,
        onItemClick: (Boolean) -> Unit,
        isExpanded: Boolean
    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally){
            Spacer(modifier = Modifier.height(8.dp))
            Row(horizontalArrangement = Arrangement.Center){
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Text(text = retrieveFoodName(userFav!!.foodId, foodList),
                    style = MaterialTheme.typography.headlineSmall,)
                    Text(text = "$${retrieveFoodPrice(userFav.foodId, foodList).formatToTwoDecimalPlaces()}",
                        style = MaterialTheme.typography.titleLarge,)}
                Icon(
                    modifier = Modifier
                        .padding(vertical = 24.dp )
                        .clickable {
                            onItemClick(!isExpanded)
                        },
                    imageVector = Icons.Default.KeyboardArrowUp,
                    contentDescription = "Arrow Down" )
            }
            ProfilePicture(userFav, foodList)

            if (userFav != null) {
                Text(" ${retrieveRestaurantName(userFav.restaurantId, restaurant)}",
                    modifier= Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.headlineSmall)
            }

            Button(
                colors = ButtonDefaults.buttonColors(PartyPink),
                onClick = {
                    if (userFav != null) {
                        navController.navigate(
                            "${Routes.Recur.route}/" +
                                "${retrieveFoodName(userFav.foodId, foodList)}/" +
                                "${retrieveFoodPrice(userFav.foodId,foodList)}/" +
                                "${retrieveRestaurantName(userFav.restaurantId, restaurant)}/" +
                                URLEncoder.encode(retrieveImage(userFav.foodId, foodList),StandardCharsets.UTF_8.toString() )

                        )
                    }
                },
                modifier= Modifier
                    .padding(16.dp)
                    .align(Alignment.CenterHorizontally)
            ) {
                Text("Set Recurring")
            }
        }
    }

    @Composable
    fun ProfilePicture(userFav: UserFavourite?, foodList: List<Food?>){
        var imageUrl: String
            Card(
                modifier = Modifier.padding(24.dp),
                shape = CircleShape,
            border = BorderStroke(2.dp, color = PartyPink),
        ) {
            imageUrl = retrieveImage(userFav!!.foodId, foodList)
            AsyncImage(
                model = imageUrl,
                contentDescription = null,
                modifier = Modifier.size(200.dp),
                contentScale = ContentScale.Crop)
        }
    }
}
    @Composable
    fun ProfilePictureUnexpanded(userFav: UserFavourite?, foodList: List<Food?>){
        var imageUrl: String
        Card(shape = CircleShape,
            border = BorderStroke(2.dp, color = PartyPink),
            modifier = Modifier.padding(16.dp)
        ) {
            imageUrl = retrieveImage(userFav!!.foodId, foodList)
            AsyncImage(
                model = imageUrl,
                contentDescription = null,
                modifier = Modifier.size(72.dp),
                contentScale = ContentScale.Crop)
        }
    }

    private fun retrieveImage(id: Int, foodList:List<Food?>): String{
    foodList.forEach{
                item-> if(id == item!!.foodId){
        return if(item.foodImage == "") {
            "no image"} else {
                item.foodImage
        }
                }
        }
        return "no image"
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
