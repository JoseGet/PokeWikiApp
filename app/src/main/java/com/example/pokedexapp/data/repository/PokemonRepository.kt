package com.example.pokedexapp.data.repository

import com.example.pokedexapp.data.api.PokeApiService
import com.example.pokedexapp.data.model.Pokemon
import com.example.pokedexapp.data.model.ResponseAllPokemon
import com.example.pokedexapp.data.model.ResponsePokemon

interface PokemonRepository {

    suspend fun getPokemonById(url: String): Pokemon

    suspend fun getAllPokemon(offset: Int): ResponseAllPokemon
}

class NetworkPokemonRepository(
    private val pokeApiService: PokeApiService
) : PokemonRepository {

    override suspend fun getPokemonById(url: String): Pokemon =
        pokeApiService.getPokemonById(url)

    override suspend fun getAllPokemon(offset: Int): ResponseAllPokemon =
        pokeApiService.getAllPokemon(offset)

}