package com.example.pokedexapp

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.pokedexapp.data.model.ResponsePokemon
import com.example.pokedexapp.data.repository.PokemonRepository
import kotlinx.coroutines.launch

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
                val listPokemon = pokemonRepository.getAllPokemon()

                Log.e("zeget", "lista de pokemon: $listPokemon")

                _mainMenuState.value = _mainMenuState.value.copy(
                    list = listPokemon.results
                )

            } catch (e: Exception) {}
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as PokeWikiApplication)
                val pokemonRepository = application.container.pokemonRepository
                MainMenuViewModel(pokemonRepository = pokemonRepository)

            }
        }
    }

    data class MainMenuState(
        val list: List<ResponsePokemon> = emptyList()
    )

}