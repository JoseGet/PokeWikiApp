package com.example.pokedexapp.data.model

data class Pokemon(
    val id: Int,
    val name: String,
    val baseExperience: Int,
    val height: Int,
    val isDefault: Boolean,
    val order: Int,
    val weight: Int,
    val abilities: PokemonAbility,
    val sprites: PokemonSprites
)
