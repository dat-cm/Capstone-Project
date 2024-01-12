
package com.example.capstoneproject.homepage.topbar

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.capstoneproject.ui.theme.PartyPink
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Suppress("ktlint:standard:function-naming")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    scope: CoroutineScope,
    drawerState: DrawerState,
) {
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(containerColor = PartyPink),
        navigationIcon = {
            IconButton(onClick = {
                scope.launch {
                    drawerState.apply {
                        if (isClosed) open() else close()
                    }
                }
            }) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = "Menu",
                    tint = Color.White,
                )
            }
        },
        title = {
            Column(
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .padding(start = 8.dp),
            ) {
                Text(
                    "Company",
                    fontSize = 20.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                )
                Text(
                    "Afro Asia Building, Afro Asia Building, " +
                        "63 Robinson Rd, Singapore 068894 Singapore, 068894",
                    color = Color.White,
                    modifier = Modifier.fillMaxWidth(),
                    fontSize = 14.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
            }
        },
        actions = {
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Default.FavoriteBorder,
                    contentDescription = "Fav",
                    tint = Color.White,
                )
            }
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Outlined.ShoppingCart,
                    contentDescription = "Bag",
                    tint = Color.White,
                )
            }
        },
    )
}
