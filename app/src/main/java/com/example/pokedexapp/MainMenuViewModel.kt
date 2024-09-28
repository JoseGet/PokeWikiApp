package com.example.pokedexapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedexapp.data.api.PokeApi
import com.example.pokedexapp.data.repository.PokemonRepository
import kotlinx.coroutines.launch

class MainMenuViewModel constructor(
    private val pokemonRepository: PokemonRepository
): ViewModel(){

    private fun getAllPokemon() {
        viewModelScope.launch {
            val listPokemon = pokemonRepository.getAllPokemon()
        }
    }

}