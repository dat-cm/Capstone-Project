package com.example.capstoneproject.homepage

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.capstoneproject.homepage.card.DineInGrid
import com.example.capstoneproject.homepage.card.FoodDeliveryGrid
import com.example.capstoneproject.homepage.card.PandaGoGrid
import com.example.capstoneproject.homepage.card.PandamartGrid
import com.example.capstoneproject.homepage.card.PickupGrid
import com.example.capstoneproject.homepage.card.ShopsGrid

@Suppress("ktlint:standard:function-naming")
@Composable
fun HomeBody()  {
    Row(
        modifier =
            Modifier
                .padding(top = 16.dp, start = 8.dp, bottom = 16.dp),
    ) {
        Column(
            horizontalAlignment = Alignment.Start,
        ) {
            // food delivery grid
            FoodDeliveryGrid()

            // pickup
            PickupGrid()

            // panda-go
            PandaGoGrid()
        }

        Column {
            // pandamart
            PandamartGrid()

            // shops
            ShopsGrid()

            // dine in
            DineInGrid()
        }
    }
}
