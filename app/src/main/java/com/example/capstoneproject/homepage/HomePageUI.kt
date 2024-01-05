package com.example.capstoneproject.homepage

import android.util.Log
import com.example.capstoneproject.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.PlayArrow
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.capstoneproject.data.createFoodProfiles
import com.example.capstoneproject.data.database.food.Food
import com.example.capstoneproject.data.database.restaurant.Restaurant
import com.example.capstoneproject.data.database.user.User
import com.example.capstoneproject.data.database.userpreferences.UserPreferences
import com.example.capstoneproject.navigator.Routes
import com.example.capstoneproject.ui.theme.CoolGrey
import com.example.capstoneproject.ui.theme.PartyPink
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class HomePageUI {
    @Composable
    fun BuildHomePageUI(navController: NavHostController, user: User?,
                        userPref: UserPreferences?, restaurantList: List<Restaurant?>,
                        foodList: List<Food?>){
        val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
        val scope = rememberCoroutineScope()

        ModalNavigationDrawer(
            drawerState = drawerState,
            drawerContent = {
                ModalDrawerSheet {
                    DrawerHeader(user)
                    if (user != null) {
                        DrawerBody(user.userPref, userPref,restaurantList,foodList){ route->
                            navController.navigate(route)
                        }
                    }
                }
            },
        ) {
            Scaffold(
                modifier = Modifier.fillMaxSize(),
                topBar = {
                    BuildTopBar(scope, drawerState)
                },
            ){
                    paddingValue->
                Column (
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(CoolGrey)
                        .padding(paddingValue),
                    horizontalAlignment = Alignment.CenterHorizontally){

                    FocusTextField()
                    BuildBody()
                }
            }
        }
    }
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun BuildTopBar(scope: CoroutineScope, drawerState : DrawerState){
        TopAppBar(
            colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = PartyPink),
            navigationIcon = {
                IconButton(onClick = {
                    scope.launch{
                        drawerState.apply{
                            if(isClosed) open() else close()
                        }
                    }
                }) {
                    Icon(
                        imageVector = Icons.Default.Menu,
                        contentDescription = "Menu",
                        tint = Color.White
                    )
                }
            },
            title =  {
                Column(modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp)) {
                    Text("Company", fontSize = 20.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold)
                    Text(
                        "Afro Asia Building, Afro Asia Building, " +
                            "63 Robinson Rd, Singapore 068894 Singapore, 068894",
                        color = Color.White,
                        modifier = Modifier.fillMaxWidth(),
                        fontSize = 14.sp,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            },
            actions = {
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Default.FavoriteBorder,
                        contentDescription = "Fav",
                        tint = Color.White
                    )
                }
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Outlined.ShoppingCart,
                        contentDescription = "Bag",
                        tint = Color.White
                    )
                }
            },
        )
    }
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun FocusTextField(){
        var search by remember { mutableStateOf("") }
        val focusManager = LocalFocusManager.current

        Box(modifier =
        Modifier
            .fillMaxWidth()
            .background(PartyPink)
        ){
            TextField(
                value = search,
                onValueChange = {search = it},
                Modifier
                    .fillMaxWidth()
                    .height(85.dp)
                    .padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 16.dp),
                keyboardOptions = KeyboardOptions(imeAction = androidx.compose.ui.text.input.ImeAction.Search),
                keyboardActions = KeyboardActions(
                    onDone = {focusManager.clearFocus()}
                ),
                label = { Text(text = "Search for shops & restaurants") },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Outlined.Search,
                        contentDescription = "Search"
                    )},
                shape = RoundedCornerShape(32.dp),
                colors =  TextFieldDefaults.textFieldColors(unfocusedIndicatorColor = Color.Transparent)
            )
        }

    }
    @Composable
    fun DrawerHeader(user: User?){
        Box(
            modifier = Modifier
                .fillMaxWidth(),
            contentAlignment = Alignment.Center){
            Divider(thickness = 1.dp, modifier = Modifier.padding(top =  60.dp))
            if (user != null) {
                Text(user.userName, fontSize = 28.sp)
            }
        }
    }
    @Composable
    fun DrawerBody(
        user_Pref: Boolean,
        userPref: UserPreferences?,
        restaurantList: List<Restaurant?>,
        foodList: List<Food?>,
        onItemClick: (String) -> Unit
    ){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Row(modifier = Modifier
                .clickable {
                    if(!user_Pref) {
                        onItemClick(Routes.Preferences.route)
                    }
                    else{
                        createFoodProfiles(userPref, restaurantList, foodList)
                        onItemClick(Routes.Selection.route)
                    }
                }
                .padding(bottom = 16.dp)) {
                Icon(
                    imageVector = Icons.Rounded.PlayArrow,
                    contentDescription = "Playlist",
                    Modifier.size(32.dp),
                    tint = PartyPink
                )
                Text(
                    text = "Food Subscription",
                    fontSize = 24.sp,
                    modifier = Modifier.padding(start = 16.dp)
                )
            }
            Row(modifier = Modifier.clickable { onItemClick(Routes.Like.route) }) {
                Icon(
                    imageVector = Icons.Rounded.Favorite,
                    contentDescription = "Likes",
                    Modifier.size(32.dp),
                    tint = PartyPink
                )
                Text(
                    text = "Likes",
                    fontSize = 24.sp,
                    modifier = Modifier.padding(start = 16.dp)
                )
            }
        }
    }

    @Composable
    fun BuildBody(){
        Row(
            modifier = Modifier
                .padding(top = 16.dp, start = 8.dp, bottom =  16.dp),){
            Column(
                horizontalAlignment = Alignment.Start,
            ) {
                //food delivery grid
                Card(
                    modifier = Modifier
                        .width(200.dp)
                        .height(275.dp)
                        .padding(
                            end = 8.dp,
                            bottom = 8.dp
                        ),
                    colors = CardDefaults.cardColors(
                            containerColor = Color.White
                    ),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 1.dp)
                        ){
                    Column(
                        modifier = Modifier
                            .padding(start = 16.dp, top = 8.dp, end = 16.dp)
                    ) {
                        Text("Food delivery",
                            fontWeight = FontWeight.Bold,
                            fontSize = 22.sp)
                        Text("Big savings on delivery!",
                            fontSize = 14.sp,
                            lineHeight = 18.sp)
                        Image(
                            painter = painterResource(id = R.drawable.delivery),
                            contentDescription = "delivery",
                           modifier = Modifier
                               .size(500.dp),
                            contentScale = ContentScale.Fit
                            )
                    }
                }

                //pickup
                Card(
                    modifier = Modifier
                        .width(200.dp)
                        .height(85.dp)
                        .padding(
                            end = 8.dp,
                            bottom = 8.dp
                        ),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    ),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 1.dp)
                ){
                    Row{
                        Column(
                            modifier = Modifier
                                .padding(start = 16.dp, top = 8.dp, end = 16.dp)
                        ) {
                            Text("Pick-up",
                                fontWeight = FontWeight.Bold,
                                fontSize = 22.sp,
                                modifier = Modifier.background(Color.White))
                            Text("Up to 50% off",
                                fontSize = 14.sp,
                                lineHeight = 18.sp)

                        }
                        Image(
                            painter = painterResource(id = R.drawable.pickup),
                            contentDescription = "pickup",
                            modifier = Modifier
                                .size(500.dp),
                            contentScale = ContentScale.Fit
                        )
                    }

                }

                //pandago
                Card(
                    modifier = Modifier
                        .width(200.dp)
                        .height(85.dp)
                        .padding(
                            end = 8.dp,
                            bottom = 8.dp
                        ),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    ),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 1.dp)
                ){
                    Row{
                        Column(
                            modifier = Modifier
                                .padding(start = 16.dp, top = 8.dp, end = 16.dp)
                        ) {
                            Text("pandago",
                                fontWeight = FontWeight.Bold,
                                fontSize = 22.sp,
                                modifier = Modifier.background(Color.White))
                            Text("Send parcels",
                                fontSize = 14.sp,
                                lineHeight = 18.sp)
                        }
                        Image(
                            painter = painterResource(id = R.drawable.pandago),
                            contentDescription = "pickup",
                            modifier = Modifier
                                .size(500.dp),
                            contentScale = ContentScale.Fit
                        )
                    }

                }
            }
            //pandamart
            Column{
                Card(
                    modifier = Modifier
                        .width(180.dp)
                        .height(180.dp)
                        .padding(
                            end = 8.dp,
                            bottom = 8.dp
                        ),
                    colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 1.dp)
                ){
                    Column(
                        modifier = Modifier
                            .padding(start = 16.dp, top = 8.dp, end = 16.dp)
                    ) {
                        Text("pandamart",
                            fontWeight = FontWeight.Bold,
                            fontSize = 22.sp,
                            modifier = Modifier.background(Color.White))
                        Text("Fresh groceries & more",
                            fontSize = 14.sp,
                            lineHeight = 18.sp)
                        Image(
                            painter = painterResource(id = R.drawable.pandamart),
                            contentDescription = "pickup",
                            modifier = Modifier
                                .size(500.dp),
                            contentScale = ContentScale.Fit
                        )
                    }
                }
                //shops
                Card(
                    modifier = Modifier
                        .width(180.dp)
                        .height(180.dp)
                        .padding(
                            end = 8.dp,
                            bottom = 8.dp
                        ),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    ),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 1.dp)
                ){
                    Column(
                        modifier = Modifier
                            .padding(start = 16.dp, top = 8.dp, end = 16.dp)
                    ) {
                        Text("Shops",
                            fontWeight = FontWeight.Bold,
                            fontSize = 22.sp,
                            modifier = Modifier.background(Color.White))
                        Text("Giant, CS Fresh & more",
                            fontSize = 14.sp,
                            lineHeight = 18.sp)
                        Image(
                            painter = painterResource(id = R.drawable.shops),
                            contentDescription = "pickup",
                            modifier = Modifier
                                .size(500.dp),
                            contentScale = ContentScale.Fit
                        )
                    }
                }
                //dine in
                Card(
                    modifier = Modifier
                        .width(180.dp)
                        .height(85.dp)
                        .padding(
                            end = 8.dp,
                            bottom = 8.dp
                        ),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    ),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 1.dp)
                ){
                    Row{
                        Column(
                            modifier = Modifier
                                .padding(start = 16.dp, top = 8.dp, end = 16.dp)
                        ) {
                            Text("Dine-in",
                                fontWeight = FontWeight.Bold,
                                fontSize = 22.sp,
                                modifier = Modifier.background(Color.White))
                            Text("Up to 50% off...",
                                fontSize = 14.sp,
                                lineHeight = 18.sp)
                        }
                        Image(
                            painter = painterResource(id = R.drawable.dinein),
                            contentDescription = "pickup",
                            modifier = Modifier
                                .size(500.dp),
                        )
                    }

                }
            }

        }

    }
}