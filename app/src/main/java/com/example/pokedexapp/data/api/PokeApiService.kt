package com.example.pokedexapp.data.api

import com.example.pokedexapp.data.model.Pokemon
import com.example.pokedexapp.data.model.ResponseAllPokemon
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokeApiService {

    @GET("pokemon/{id}/")
    suspend fun getPokemonById(@Path("id") id: String): Pokemon

    @GET("pokemon/{offset}")
    suspend fun getAllPokemon(@Query("offset") offset: Int): ResponseAllPokemon

    @GET("ability/{id}/")
    suspend fun getAbilitiesById(@Path("id") id: Int)

}