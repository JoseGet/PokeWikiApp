package com.example.pokedexapp.ui.models

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import com.example.pokedexapp.data.model.Pokemon

@Composable
fun PokemonCard(
    pokemon: Pokemon
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
                pokemon.sprites.frontDefault,
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

}