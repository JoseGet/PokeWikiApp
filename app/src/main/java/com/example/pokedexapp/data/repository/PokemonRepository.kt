package com.example.pokedexapp.data.repository

import com.example.pokedexapp.data.api.PokeApi
import com.example.pokedexapp.data.model.Pokemon

class PokemonRepository (
    private val pokemonApi: PokeApi
) {
    suspend fun getPokemonById(id: Int): Pokemon{
        return pokemonApi.retrofitService.getPokemonById(id)
    }
}