package com.example.pokedexapp

import android.app.Application
import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.referentialEqualityPolicy
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.pokedexapp.data.model.AllPokemon
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
                val listPokemon: List<Pokemon> = pokemonRepository.getAllPokemon()

                Log.e("zeget", "lista de pokemon: $listPokemon")

                _mainMenuState.value = mainMenuState.value.copy(
                    list = listPokemon
                )

            } catch (e: IOException) {}
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
        val list: List<Pokemon> = emptyList()
    )

}