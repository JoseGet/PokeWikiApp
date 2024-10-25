package com.example.pokedexapp.Home.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.pokedexapp.Home.ui.models.HomePageGrid
import com.example.pokedexapp.Home.ui.models.TopBar

@Composable
fun HomePage() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {

        TopBar()
        HomePageGrid()

    }

}

@Preview
@Composable
fun HomePagePreview() {
    HomePage()
}