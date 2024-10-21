package com.example.pokedexapp.data.repository

import com.example.pokedexapp.data.api.PokeApiService
import com.example.pokedexapp.data.model.Pokemon
import com.example.pokedexapp.data.model.ResponseAllPokemon
import com.example.pokedexapp.data.model.ResponsePokemon

interface PokemonRepository {

    suspend fun getPokemonById(id: Int): Pokemon

    suspend fun getAllPokemon(): ResponseAllPokemon
}

class NetworkPokemonRepository(
    private val pokeApiService: PokeApiService
) : PokemonRepository {

    override suspend fun getPokemonById(id: Int): Pokemon =
        pokeApiService.getPokemonById(id)

    override suspend fun getAllPokemon(): ResponseAllPokemon =
        pokeApiService.getAllPokemon()

}