package com.example.pokedexapp.data

import com.example.pokedexapp.data.api.PokeApiService
import com.example.pokedexapp.data.repository.NetworkPokemonRepository
import com.example.pokedexapp.data.repository.PokemonRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface AppContainer {

    val pokemonRepository: PokemonRepository

}

class DefaultAppContainer : AppContainer {

    private val POKEURL = "https://pokeapi.co/api/v2/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(POKEURL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val retrofitService: PokeApiService by lazy {
        retrofit.create(PokeApiService::class.java)
    }


    override val pokemonRepository: PokemonRepository by lazy {
        NetworkPokemonRepository(retrofitService)
    }

}