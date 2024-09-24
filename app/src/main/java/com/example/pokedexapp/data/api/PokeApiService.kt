package com.example.pokedexapp.data.api

import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

private const val POKE_URL = "https://pokeapi.co/api/v2"

private val retrofit = Retrofit.Builder()
    .baseUrl(POKE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()


interface PokeApiService {

    @GET("/pokemon/{id}")
    suspend fun getPokemonById(@Path("id") id: Int)

}