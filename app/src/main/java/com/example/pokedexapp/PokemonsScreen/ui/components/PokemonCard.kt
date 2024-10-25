package com.example.pokedexapp.PokemonsScreen.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import com.example.pokedexapp.data.model.ResponsePokemon

@Composable
fun PokemonCard(
    pokemon: ResponsePokemon
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
    PokemonCard(pokemon = responsePokemon)
}