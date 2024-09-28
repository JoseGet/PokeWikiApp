package com.example.pokedexapp.data.api

import com.example.pokedexapp.data.model.AllPokemon
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

object PokeApi {
    val retrofitService: PokeApiService by lazy {
        retrofit.create(PokeApiService::class.java)
    }
}

interface PokeApiService {

    @GET("/pokemon/{id}")
    suspend fun getPokemonById(@Path("id") id: Int)

    @GET()
    suspend fun getAllPokemon(): AllPokemon

    @GET("/ability/{id}")
    suspend fun getAbilitiesById(@Path("id") id: Int)

}