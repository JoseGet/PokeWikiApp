package com.example.pokedexapp.Pokemons.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.pokedexapp.Home.ui.models.TopBar
import com.example.pokedexapp.Pokemons.PokemonsViewModel
import com.example.pokedexapp.Pokemons.ui.components.PokemonCard
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.filter

@Composable
fun PokemonsScreen(
    navController: NavController,
    buffer: Int = 2
){

    val pokemonViewModel: PokemonsViewModel = viewModel(factory = PokemonsViewModel.Factory)
    val mainMenuState by pokemonViewModel.pokemonsState

    val listState = rememberLazyGridState();

    val coroutineScope = rememberCoroutineScope()

    val shouldLoadMore = remember {
        derivedStateOf {
            val totalItemsCount = listState.layoutInfo.totalItemsCount
            val lastVisibleItemIndex = listState.layoutInfo.visibleItemsInfo.lastOrNull()?.index ?: 0
            lastVisibleItemIndex >= (totalItemsCount - buffer) && !mainMenuState.isLoading
        }
    }

    LaunchedEffect(listState) {
        snapshotFlow { shouldLoadMore.value }
            .distinctUntilChanged()
            .filter { it }
            .collect {
                pokemonViewModel.loadMoreItems()
            }
    }

    Column(
       modifier = Modifier.fillMaxSize()
    ){
        TopBar(navController)

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
        ){
            items(mainMenuState.list) { item ->
                PokemonCard(pokemon = item, pokemonViewModel)
            }
        }
    }

}
