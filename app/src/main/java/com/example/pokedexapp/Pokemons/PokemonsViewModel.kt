package com.example.pokedexapp.Pokemons

import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.geometry.Offset
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.pokedexapp.PokeWikiApplication
import com.example.pokedexapp.data.model.Pokemon
import com.example.pokedexapp.data.model.ResponsePokemon
import com.example.pokedexapp.data.repository.PokemonRepository
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class PokemonsViewModel(
    private val pokemonRepository: PokemonRepository
): ViewModel(){

    private val _PokemonsState = mutableStateOf(PokemonsState())
    var pokemonsState: State<PokemonsState> = _PokemonsState

    private var offset = 0

    init {
        getAllPokemon(offset)
    }

    private fun getAllPokemon(offset: Int) {
        viewModelScope.launch {

            try {
                val listPokemon = pokemonRepository.getAllPokemon(offset)

                _PokemonsState.value = _PokemonsState.value.copy(
                    list = listPokemon.results
                )

            } catch (e: Exception) {}
        }
    }

    fun loadMoreItems() {
        viewModelScope.launch {
            val currentList = _PokemonsState.value.list
            this@PokemonsViewModel.offset += 20
            val newList = pokemonRepository.getAllPokemon(offset).results

            val finalList = (currentList + newList)

            _PokemonsState.value = _PokemonsState.value.copy(
                list = finalList
            )
        }
    }

    fun getOnePokemon(url: String) {
        viewModelScope.launch {
            try {
                val onePokemon: Pokemon = pokemonRepository.getPokemonById(url)

            } catch (e: Exception) {}
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as PokeWikiApplication)
                val pokemonRepository = application.container.pokemonRepository
                PokemonsViewModel(pokemonRepository = pokemonRepository)

            }
        }
    }

    data class PokemonsState(
        val list: List<ResponsePokemon> = emptyList(),
        val isError : Boolean = false,
        val isLoading: Boolean = false
    )

}