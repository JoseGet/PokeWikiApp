package com.example.pokedexapp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.pokedexapp.data.model.AllPokemon
import com.example.pokedexapp.data.model.Pokemon
import com.example.pokedexapp.data.repository.PokemonRepository
import com.example.pokedexapp.ui.models.PokemonCard

@Composable
fun MainMenu(){

    val pokemonViewModel: MainMenuViewModel = viewModel()
    val mainMenuState by pokemonViewModel.mainMenuState
    val pokemon: AllPokemon

    Column(
       modifier = Modifier.fillMaxSize()
    ){
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
        ){
            items(mainMenuState.list)
            { pokemon ->
                PokemonCard(pokemon = pokemon)
            }
        }
    }

}

@Preview
@Composable

fun MainMenuPreview(

){

}