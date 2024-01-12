package com.example.capstoneproject.homepage.drawer

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.PlayArrow
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.capstoneproject.data.database.user.User
import com.example.capstoneproject.navigator.Routes
import com.example.capstoneproject.ui.theme.PartyPink

@Suppress("ktlint:standard:function-naming")
@Composable
fun DrawerHeader(user: User?) {
    Box(
        modifier =
            Modifier
                .fillMaxWidth(),
        contentAlignment = Alignment.Center,
    ) {
        Divider(thickness = 1.dp, modifier = Modifier.padding(top = 60.dp))
        if (user != null) {
            Text(user.userName, fontSize = 28.sp)
        }
    }
}

@Suppress("ktlint:standard:function-naming")
@Composable
fun DrawerBody(
    userPref: Boolean,
    onItemClick: (String) -> Unit,
) {
    Column(
        modifier =
            Modifier
                .fillMaxWidth()
                .padding(16.dp),
    ) {
        Row(
            modifier =
                Modifier
                    .clickable {
                        if (!userPref) {
                            onItemClick(Routes.Preferences.route)
                        } else {
                            //
                            onItemClick(Routes.Selection.route)
                        }
                    }
                    .padding(bottom = 16.dp),
        ) {
            Icon(
                imageVector = Icons.Rounded.PlayArrow,
                contentDescription = "Playlist",
                Modifier.size(32.dp),
                tint = PartyPink,
            )
            Text(
                text = "Food Subscription",
                fontSize = 24.sp,
                modifier = Modifier.padding(start = 16.dp),
            )
        }
        Row(modifier = Modifier.clickable { onItemClick(Routes.Like.route) }) {
            Icon(
                imageVector = Icons.Rounded.Favorite,
                contentDescription = "Likes",
                Modifier.size(32.dp),
                tint = PartyPink,
            )
            Text(
                text = "Likes",
                fontSize = 24.sp,
                modifier = Modifier.padding(start = 16.dp),
            )
        }
    }
}
