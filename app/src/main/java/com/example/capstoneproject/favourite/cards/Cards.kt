package com.example.capstoneproject.favourite.cards

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import com.example.capstoneproject.data.database.CapstoneViewModel
import com.example.capstoneproject.data.database.food.Food
import com.example.capstoneproject.data.database.restaurant.Restaurant
import com.example.capstoneproject.data.database.userfavourite.UserFavourite
import com.example.capstoneproject.data.decimal.formatToTwoDecimalPlaces
import com.example.capstoneproject.data.foodNameDataFinder
import com.example.capstoneproject.data.foodPriceDataFinder
import com.example.capstoneproject.data.imageDataFinder
import com.example.capstoneproject.data.restaurantNameDataFinder
import com.example.capstoneproject.favourite.profileimage.ProfilePicture
import com.example.capstoneproject.favourite.profileimage.ProfilePictureUnexpanded
import com.example.capstoneproject.navigator.Routes
import com.example.capstoneproject.ui.theme.CoolGrey
import com.example.capstoneproject.ui.theme.PartyPink
import kotlinx.coroutines.launch
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

@Suppress("ktlint:standard:function-naming")
@Composable
fun UnexpandedCard(
    isExpanded: Boolean,
    userFav: UserFavourite?,
    foodList: List<Food?>,
    onItemClick: (Boolean) -> Unit,
) {
    Column(
        modifier = Modifier.padding(bottom = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ) {
            ProfilePictureUnexpanded(userFav, foodList)
            Column {
                Text(
                    text = foodNameDataFinder(userFav!!.foodId, foodList),
                    style = MaterialTheme.typography.headlineSmall,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = "$${foodPriceDataFinder(userFav.foodId, foodList).formatToTwoDecimalPlaces()}",
                    style = MaterialTheme.typography.titleLarge,
                )

            }
        }
        Icon(
            modifier =
            Modifier
                .padding(start = 8.dp)
                .clickable {
                    onItemClick(!isExpanded)
                },
            imageVector = Icons.Default.KeyboardArrowDown,
            contentDescription = "Arrow Down",
        )
    }
}

@Suppress("ktlint:standard:function-naming")
@Composable
fun ExpandedCard(
    navController: NavHostController,
    restaurant: List<Restaurant?>,
    userFav: UserFavourite?,
    foodList: List<Food?>,
    onItemClick: (Boolean) -> Unit,
    isExpanded: Boolean,
    capstoneViewModel: CapstoneViewModel
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.height(8.dp))
        Row(horizontalArrangement = Arrangement.Center) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    text = foodNameDataFinder(userFav!!.foodId, foodList),
                    style = MaterialTheme.typography.headlineSmall,
                )
                Text(
                    text = "$${foodPriceDataFinder(userFav.foodId, foodList).formatToTwoDecimalPlaces()}",
                    style = MaterialTheme.typography.titleLarge,
                )
            }
        }
        ProfilePicture(userFav, foodList)

        if (userFav != null) {
            Text(
                " ${restaurantNameDataFinder(userFav.restaurantId, restaurant)}",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.headlineSmall,
            )
        }

        Button(
            colors = ButtonDefaults.buttonColors(PartyPink),
            onClick = {
                if (userFav != null) {
                    navController.navigate(
                        "${Routes.Recur.route}/" +
                            "${foodNameDataFinder(userFav.foodId, foodList)}/" +
                            "${foodPriceDataFinder(userFav.foodId, foodList)}/" +
                            "${restaurantNameDataFinder(userFav.restaurantId, restaurant)}/" +
                            URLEncoder.encode(
                                imageDataFinder(userFav.foodId, foodList),
                                StandardCharsets.UTF_8
                                    .toString(),
                            ) + "/${userFav.favId}",
                    )
                }
            },
            modifier =
            Modifier
                .padding(16.dp)
                .align(Alignment.CenterHorizontally),
        ) {
            Text("Set Recurring")
        }

        Button(
            colors = ButtonDefaults.buttonColors(PartyPink),
            onClick = {
                capstoneViewModel.viewModelScope.launch {
                    if (userFav != null) {
                        capstoneViewModel.deleteUserFav(userFav.favId)
                    }
                }
            },
            modifier =
            Modifier
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 16.dp)
        ) {
            Text(
                "Remove",
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }

        Icon(
            modifier =
            Modifier
                .clickable { onItemClick(!isExpanded) }
                .padding(bottom = 16.dp),
            imageVector = Icons.Default.KeyboardArrowUp,
            contentDescription = "Arrow Down",
        )
    }
}

@Suppress("ktlint:standard:function-naming")
@Composable
fun ExpandableFoodItem(
    userFav: UserFavourite?,
    navController: NavHostController,
    restaurant: List<Restaurant?>,
    foodList: List<Food?>,
    capstoneViewModel: CapstoneViewModel
) {
    var isExpanded by remember { mutableStateOf(false) }
    ElevatedCard(
        modifier =
        Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .wrapContentHeight(align = Alignment.Top),
        colors = CardDefaults.cardColors(CoolGrey),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
    ) {
        if (!isExpanded) {
            UnexpandedCard(isExpanded, userFav, foodList, onItemClick = { isExpanded = it })
        } else {
            ExpandedCard(
                navController, restaurant, userFav, foodList, onItemClick = { isExpanded = it }, isExpanded,
                capstoneViewModel
            )
        }
    }
}
