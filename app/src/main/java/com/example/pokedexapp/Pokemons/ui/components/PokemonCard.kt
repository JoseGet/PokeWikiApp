package com.example.pokedexapp.Pokemons.ui.components

import android.util.Log
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.pokedexapp.Pokemons.PokemonsViewModel
import com.example.pokedexapp.data.model.Pokemon
import com.example.pokedexapp.data.model.ResponsePokemon
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.coroutineScope

@Composable
fun PokemonCard(
    pokemon: ResponsePokemon,
    viewModel: PokemonsViewModel
) {

    Card (
        modifier = Modifier,
        border = null
    ){
        Column(
            modifier = Modifier,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(model =
                pokemon.url,
                contentDescription = null)

            Text(
                text = pokemon.name
            )
        }

    }
}

@Preview
@Composable
fun PokemonCardPreview() {
    val responsePokemon = ResponsePokemon(name = "Pikachu", url = "pikachu")
    //PokemonCard(pokemon = responsePokemon, viewModel)
}