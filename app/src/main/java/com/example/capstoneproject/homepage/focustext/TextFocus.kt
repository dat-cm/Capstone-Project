package com.example.capstoneproject.homepage.focustext

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.example.capstoneproject.ui.theme.PartyPink

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
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
            keyboardActions = KeyboardActions(
                onDone = {focusManager.clearFocus()}
            ),
            label = { Text(text = "Search for shops & restaurants") },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Outlined.Search,
                    contentDescription = "Search"
                )
            },
            shape = RoundedCornerShape(32.dp),
            colors =  TextFieldDefaults.colors(unfocusedIndicatorColor = Color.Transparent)
        )
    }
}
