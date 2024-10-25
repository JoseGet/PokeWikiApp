package com.example.pokedexapp.Home.ui.models

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.pokedexapp.navigation.routes.HomePageRoutes

@Composable
fun HomePageGrid(
    navController: NavController
) {

    val gridList: List<String> = listOf("Pokemons", "Games", "Musics", "Items")

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier
            .padding(20.dp),
        contentPadding = PaddingValues(20.dp)
    ) {

        items(4){item ->
            HomePageGridCard(message = gridList[item], navController)
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePageGridCard(
    message: String,
    navController: NavController
) {
    Card(
        modifier = Modifier
            .padding(20.dp)
            .background(Color.Transparent)
            .size(80.dp),
        onClick = {
            navController.navigate(HomePageRoutes.Pokemons.name)
        }
    ) {

        Spacer(modifier = Modifier.padding(top = 30.dp))

        Text(
            text = message,
            modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)
        )

    }
}

@Preview
@Composable
fun HomePageGridPreview() {
    //HomePageGrid()
}