package com.example.capstoneproject.selection.swipeables

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.capstoneproject.data.createFoodProfiles
import com.example.capstoneproject.data.database.CapstoneViewModel
import com.example.capstoneproject.data.database.food.Food
import com.example.capstoneproject.data.database.restaurant.Restaurant
import com.example.capstoneproject.data.database.user.User
import com.example.capstoneproject.data.database.userpreferences.UserPreferences
import com.example.capstoneproject.data.foodChoiceList
import com.example.capstoneproject.ui.theme.PartyPink
import kotlinx.coroutines.launch

@Suppress("ktlint:standard:function-naming")
@Composable
fun SwipeCard(
    capstoneViewModel: CapstoneViewModel,
    user: User?,
    userPref: UserPreferences?,
    restaurantList: List<Restaurant?>,
    foodList: List<Food?>,
    padding: PaddingValues,
) {
    val viewModel = SwipeViewModel(capstoneViewModel)
    val scope = rememberCoroutineScope()
    var foodState by remember {
        mutableStateOf(Food("", 0.00, "", "", 1))
    }
    createFoodProfiles(userPref, restaurantList, foodList)
    val states: List<Pair<Food, SwipeableCardState>> =
        foodChoiceList.reversed()
            .map { it to rememberSwipeableCardState() }
    Column {
        Box(
            modifier =
                Modifier
                    .padding(
                        top = padding.calculateTopPadding() + 24.dp,
                        start = 24.dp,
                        end = 24.dp,
                    )
                    .aspectRatio(0.75f),
        ) {
            states.forEach { (matchFood, state) ->
                if (state.swipedDirection == null) {
                    FoodCard(
                        modifier =
                            Modifier
                                .fillMaxSize()
                                .aspectRatio(1f)
                                .swipableCard(
                                    state = state,
                                    blockedDirections = listOf(Direction.Down, Direction.Up),
                                    onSwiped = {
                                        // swipes are handled by the LaunchedEffect
                                        // so that we track button clicks & swipes
                                        // from the same place
                                        if (state.swipedDirection == Direction.Right) {
                                            viewModel.saveSwipeCard(user, matchFood)
                                        }
                                    },
                                    onSwipeCancel = {
                                        // Log.d("Swipeable-Card", "Cancelled swipe")
                                        // hint = "You canceled the swipe"
                                    },
                                ),
                        matchFood = matchFood,
                    )
                    foodState = matchFood
                }
            }
        }
        Row(
            Modifier
                .padding(horizontal = 24.dp, vertical = 32.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.Bottom,
        ) {
            CircleButton(
                onClick = {
                    scope.launch {
                        states.reversed().firstOrNull { it.second.offset.value == Offset(0f, 0f) }?.second?.swipe(Direction.Left)
                    }
                },
                icon = Icons.Rounded.Close,
            )
            CircleButton(
                onClick = {
                    viewModel.saveSwipeCard(user, foodState)
                    scope.launch {
                        states.reversed().firstOrNull { it.second.offset.value == Offset(0f, 0f) }?.second?.swipe(Direction.Right)
                    }
                    /*capstoneViewModel.viewModelScope.launch {
                        val last =
                            states.reversed()
                                .firstOrNull {
                                    it.second.offset.value == Offset(0f, 0f)
                                }?.second

                        last?.swipe(Direction.Right)
                    }*/
                },
                icon = Icons.Rounded.Favorite,
            )
        }
    }
}

@Suppress("ktlint:standard:function-naming")
@Composable
fun CircleButton(
    onClick: () -> Unit,
    icon: ImageVector,
) {
    IconButton(
        modifier =
            Modifier
                .clip(CircleShape)
                .background(PartyPink)
                .size(56.dp)
                .border(2.dp, PartyPink, CircleShape),
        onClick = onClick,
    ) {
        Icon(
            icon,
            null,
            tint = MaterialTheme.colorScheme.onPrimary,
        )
    }
}

@Suppress("ktlint:standard:function-naming")
@Composable
fun FoodCard(
    modifier: Modifier,
    matchFood: Food,
) {
    Card(modifier) {
        Box {
            AsyncImage(
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize(),
                model = matchFood.foodImage,
                contentDescription = null,
            )
            Scrim(Modifier.align(Alignment.BottomCenter))
            Column(Modifier.align(Alignment.BottomStart)) {
                Text(
                    text = matchFood.foodName,
                    color = MaterialTheme.colorScheme.onPrimary,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.padding(10.dp),
                )
            }
        }
    }
}

@Suppress("ktlint:standard:function-naming")
@Composable
private fun Hint(text: String) {
    Box(
        contentAlignment = Alignment.Center,
        modifier =
            Modifier
                .padding(horizontal = 24.dp, vertical = 32.dp)
                .fillMaxWidth(),
    ) {
        Text(
            text = text,
            color = MaterialTheme.colorScheme.onPrimary,
            fontWeight = FontWeight.Bold,
            fontSize = 22.sp,
            textAlign = TextAlign.Center,
        )
    }
}

private fun stringFrom(direction: Direction): String {
    return when (direction) {
        Direction.Left -> "Left 👈"
        Direction.Right -> "Right 👉"
        Direction.Up -> "Up 👆"
        Direction.Down -> "Down 👇"
    }
}

@Suppress("ktlint:standard:function-naming")
@Composable
fun Scrim(modifier: Modifier = Modifier) {
    Box(
        modifier
            .background(Brush.verticalGradient(listOf(Color.Transparent, Color.Black)))
            .height(180.dp)
            .fillMaxWidth(),
    )
}
