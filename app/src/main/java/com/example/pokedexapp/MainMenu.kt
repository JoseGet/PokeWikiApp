package com.example.pokedexapp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pokedexapp.ui.models.PokemonCard

@Composable
fun MainMenu(){

    val pokemonViewModel: MainMenuViewModel = viewModel()
    val mainMenuState by pokemonViewModel.mainMenuState

    Column(
       modifier = Modifier.fillMaxSize()
    ){
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
        ){
            items(items = mainMenuState.list, key = {pokemon -> pokemon.id}) { pokemon ->
                PokemonCard(pokemon = pokemon)
            }
        }
    }

}
