package com.example.pokedexapp.data.api

import com.example.pokedexapp.data.model.AllPokemon
import com.example.pokedexapp.data.model.Pokemon
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface PokeApiService {

    @GET("pokemon/{id}/")
    suspend fun getPokemonById(@Path("id") id: Int): Pokemon

    @GET("pokemon/")
    suspend fun getAllPokemon(): AllPokemon

    @GET("ability/{id}/")
    suspend fun getAbilitiesById(@Path("id") id: Int)

}