package com.example.pokedexapp.Pokemons

import android.util.Log
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
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

class PokemonsViewModel(
    private val pokemonRepository: PokemonRepository
): ViewModel(){

    private val _PokemonsState = MutableStateFlow(PokemonsState())
    var pokemonsState: StateFlow<PokemonsState> = _PokemonsState.asStateFlow()

    private var offset = 0

    init {
        getAllPokemon(offset)
    }

    private fun getAllPokemon(offset: Int) {
        viewModelScope.launch {
            try {

                _PokemonsState.update { it.copy(isLoading = true) }

                val listPokemon = pokemonRepository.getAllPokemon(offset)

                Log.d("zeget", "primeira chamada: $listPokemon")

                _PokemonsState.update { state ->
                    state.copy(
                        list = listPokemon.results,
                        isLoading = false
                    )
                }

                Log.d("zeget", "estado pos chamada: ${_PokemonsState.value.list}")

            } catch (e: Exception) {}
        }
    }

    fun loadMoreItems() {
        viewModelScope.launch {

            try {

                _PokemonsState.update { it.copy(isLoading = true) }

                val currentList = _PokemonsState.value.list
                this@PokemonsViewModel.offset += 20
                val newList = pokemonRepository.getAllPokemon(offset).results

                val finalList = currentList + newList

                _PokemonsState.update { state ->
                    state.copy(
                        list = finalList,
                        isLoading = false
                    )
                }

                Log.d("zeget", "here: $currentList")
                Log.d("zeget", "aqui : $finalList")

            } catch (e: Exception) {}
        }
    }

//    fun getOnePokemon(url: String) {
//        viewModelScope.launch {
//            try {
//                val onePokemon: Pokemon = pokemonRepository.getPokemonById(url)
//
//            } catch (e: Exception) {}
//        }
//    }

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