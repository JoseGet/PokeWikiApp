package com.example.pokedexapp.PokemonsScreen.ui

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.pokedexapp.Home.ui.models.TopBar
import com.example.pokedexapp.PokemonsScreen.MainMenuViewModel
import com.example.pokedexapp.PokemonsScreen.ui.components.PokemonCard

@Composable
fun PokemonsScreen(
    navController: NavController
){

    val pokemonViewModel: MainMenuViewModel = viewModel(factory = MainMenuViewModel.Factory)
    val mainMenuState by pokemonViewModel.mainMenuState

    Column(
       modifier = Modifier.fillMaxSize()
    ){
        TopBar(navController)

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
        ){
            items(mainMenuState.list) { item ->
                PokemonCard(pokemon = item)
            }
        }
    }

}
