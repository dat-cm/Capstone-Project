package com.example.capstoneproject.favourite.profileimage

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.capstoneproject.data.database.food.Food
import com.example.capstoneproject.data.database.userfavourite.UserFavourite
import com.example.capstoneproject.data.imageDataFinder
import com.example.capstoneproject.ui.theme.PartyPink

@Suppress("ktlint:standard:function-naming")
@Composable
fun ProfilePicture(
    userFav: UserFavourite?,
    foodList: List<Food?>,
) {
    var imageUrl: String
    Card(
        modifier = Modifier.padding(24.dp),
        shape = CircleShape,
        border = BorderStroke(2.dp, color = PartyPink),
    ) {
        imageUrl = imageDataFinder(userFav!!.foodId, foodList)
        AsyncImage(
            model = imageUrl,
            contentDescription = null,
            modifier = Modifier.size(200.dp),
            contentScale = ContentScale.Crop,
        )
    }
}

@Suppress("ktlint:standard:function-naming")
@Composable
fun ProfilePictureUnexpanded(
    userFav: UserFavourite?,
    foodList: List<Food?>,
) {
    var imageUrl: String
    Card(
        shape = CircleShape,
        border = BorderStroke(2.dp, color = PartyPink),
        modifier = Modifier.padding(16.dp),
    ) {
        imageUrl = imageDataFinder(userFav!!.foodId, foodList)
        AsyncImage(
            model = imageUrl,
            contentDescription = null,
            modifier = Modifier.size(72.dp),
            contentScale = ContentScale.Crop,
        )
    }
}
