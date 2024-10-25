package com.example.pokedexapp.Home.ui.models

import android.graphics.drawable.Icon
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun TopBar() {

    Row (
        modifier = Modifier
            .background(color = Color.White)
            .fillMaxWidth()
            .statusBarsPadding(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Absolute.SpaceBetween
    ){
        IconButton(
            onClick = { /*TODO*/ }
        ) {
            Icon(imageVector = Icons.Rounded.Menu, contentDescription = "Menu")
        }

        Text(
            modifier = Modifier,
            text = "PokeWiki",

        )

        IconButton(
            onClick = { /*TODO*/ }
        ) {
            Icon(imageVector = Icons.Rounded.AccountCircle, contentDescription = "Menu")
        }

    }

}

@Preview
@Composable
fun TopBarPreview() {
    TopBar()
}