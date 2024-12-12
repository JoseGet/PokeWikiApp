package com.example.pokedexapp.Pokemons.ui.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.pokedexapp.Pokemons.PokemonsViewModel
import com.example.pokedexapp.R
import com.example.pokedexapp.data.model.Pokemon
import com.example.pokedexapp.data.model.ResponsePokemon
import com.example.pokedexapp.data.repository.PokemonRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.coroutineScope

@Composable
fun PokemonCard(
    pokemon: ResponsePokemon,
    id: Int
) {
    Card (
        modifier = Modifier,
        border = null
    ){
        Column(
            modifier = Modifier.wrapContentSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                model = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${id}.png",
                contentDescription = null,
                modifier = Modifier
                    .size(200.dp)
            )
            Text(
                text = pokemon.name,
                fontSize = 20.sp
            )
        }

    }
}

@Preview
@Composable
fun PokemonCardPreview() {

    val image_for_test = R.drawable.bulbasaur.toString()

    val fakeResponsePokemon = ResponsePokemon(
        name = "Bulbasaur",
        url = image_for_test
    )
    PokemonCard(pokemon = fakeResponsePokemon, id = 0)
}