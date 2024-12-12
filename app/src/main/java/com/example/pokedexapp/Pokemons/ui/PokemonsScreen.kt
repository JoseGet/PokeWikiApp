package com.example.pokedexapp.Pokemons.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.pokedexapp.Home.ui.models.TopBar
import com.example.pokedexapp.Pokemons.PokemonsViewModel
import com.example.pokedexapp.Pokemons.ui.components.PokemonCard
import com.example.pokedexapp.Pokemons.ui.components.TitleRow
import com.example.pokedexapp.R
import com.example.pokedexapp.data.model.ResponsePokemon
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.filter

@Composable
fun PokemonsScreen(
    buffer: Int = 2,
){

    val pokemonViewModel: PokemonsViewModel = viewModel(factory = PokemonsViewModel.Factory)
    val mainMenuState by pokemonViewModel.pokemonsState.collectAsState()

    val listState = rememberLazyGridState();

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

    PokemonsScreenColumn(
        listState,
        mainMenuState
    )
}

@Composable
fun PokemonsScreenColumn(
    listState: LazyGridState,
    mainMenuState: PokemonsViewModel.PokemonsState
){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.background_pokemon_list)),
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        Spacer(modifier = Modifier.height(12.dp))

        TitleRow()

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.fillMaxSize(),
            state = listState,
        ){
            itemsIndexed(mainMenuState.list) { index, item ->
                PokemonCard(pokemon = item, id = index + 1)
            }
        }
    }
}

@Preview
@Composable
fun PokemonsScreenColumnPreview() {
    PokemonsScreenColumn(
        listState = rememberLazyGridState(),
        mainMenuState = PokemonsViewModel.PokemonsState()
    )
}

