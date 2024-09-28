package com.example.pokedexapp.data.repository

import com.example.pokedexapp.data.api.PokeApiService
import com.example.pokedexapp.data.model.AllPokemon

class PokemonRepository constructor(
    private val pokemonService: PokeApiService
) {
    suspend fun getPokemonById(id: Int){
        return pokemonService.getPokemonById(id)
    }

    suspend fun getAllPokemon(): AllPokemon{
        return pokemonService.getAllPokemon()
    }
}