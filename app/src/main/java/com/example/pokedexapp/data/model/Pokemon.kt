package com.example.pokedexapp.data.model

data class Pokemon(
    val id: Int,
    val name: String,
    val baseExperience: Int,
    val height: Int,
    val isDefault: Boolean,
    val order: Int,
    val weight: Int
)

data class AllPokemon(val pokemons: List<Pokemon>)