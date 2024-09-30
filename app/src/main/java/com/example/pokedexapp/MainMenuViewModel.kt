package com.example.pokedexapp

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedexapp.data.api.PokeApi
import com.example.pokedexapp.data.model.Pokemon
import com.example.pokedexapp.data.repository.PokemonRepository
import kotlinx.coroutines.launch

class MainMenuViewModel constructor(
    private val pokemonRepository: PokemonRepository
): ViewModel(){

    private val _mainMenuState = mutableStateOf(MainMenuState())
    val mainMenuState: State<MainMenuState> = _mainMenuState

    init {
        getAllPokemon()
    }

    private fun getAllPokemon() {
        viewModelScope.launch {
            val listPokemon = pokemonRepository.getAllPokemon()
            _mainMenuState.value = _mainMenuState.value.copy(
                list = listPokemon.pokemons
            )
        }
    }

    data class MainMenuState(
        val list: List<Pokemon> = emptyList()
    )

}