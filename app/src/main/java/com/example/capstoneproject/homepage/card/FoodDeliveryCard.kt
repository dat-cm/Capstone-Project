package com.example.capstoneproject.homepage.card

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.capstoneproject.R

@Composable
fun FoodDeliveryGrid(){
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
}