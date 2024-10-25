package com.example.pokedexapp.Home.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.testing.TestNavHostController
import com.example.pokedexapp.Home.ui.models.HomePageGrid
import com.example.pokedexapp.Home.ui.models.TopBar

@Composable
fun HomePage(
    navController: NavController
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {

        TopBar(navController)
        HomePageGrid(navController)

    }

}

@Preview
@Composable
fun HomePagePreview() {
    val navController = TestNavHostController(LocalContext.current)
    HomePage(navController = navController)
}