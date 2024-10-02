package com.example.pokedexapp

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedexapp.data.model.Pokemon
import com.example.pokedexapp.data.repository.PokemonRepository
import kotlinx.coroutines.launch
import okio.IOException

class MainMenuViewModel(
    private val pokemonRepository: PokemonRepository
): ViewModel(){

    private val _mainMenuState = mutableStateOf(MainMenuState())
    var mainMenuState: State<MainMenuState> = _mainMenuState

    init {
        getAllPokemon()
    }

    private fun getAllPokemon() {
        viewModelScope.launch {

            try {
                val listPokemon : MutableList<Pokemon> = emptyList<Pokemon>().toMutableList()

                for(i in 1..30)
                {
                    listPokemon[i] = pokemonRepository.getPokemonById(i)
                }

                _mainMenuState.value = _mainMenuState.value.copy(
                    list = listPokemon
                )
            } catch (e: IOException){}
        }
    }

    data class MainMenuState(
        val list: List<Pokemon> = emptyList()
    )

}