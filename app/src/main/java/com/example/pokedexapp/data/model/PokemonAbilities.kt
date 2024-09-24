package com.example.pokedexapp.data.model

data class PokemonAbilities(
    val id: Int,
    val name: String,
    val isMainSeries: Boolean
)

data class PokemonAbilitiesList(val abilities: List<PokemonAbilities>)