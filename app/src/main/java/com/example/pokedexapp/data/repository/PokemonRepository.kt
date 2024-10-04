package com.example.pokedexapp.data.repository

import com.example.pokedexapp.data.api.PokeApiService
import com.example.pokedexapp.data.model.Pokemon

interface PokemonRepository {

    suspend fun getPokemonById(id: Int): Pokemon

    suspend fun getAllPokemon(): List<Pokemon>
}

class NetworkPokemonRepository(
    private val pokeApiService: PokeApiService
) : PokemonRepository {

    override suspend fun getPokemonById(id: Int): Pokemon =
        pokeApiService.getPokemonById(id)

    override suspend fun getAllPokemon(): List<Pokemon> =
        pokeApiService.getAllPokemon().allPokemon

}