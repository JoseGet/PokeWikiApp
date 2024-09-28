package com.example.pokedexapp.data.model

data class Abilities(
    val id: Int,
    val name: String,
    val isMainSeries: Boolean
)

data class AbilitiesList(val abilities: List<Abilities>)