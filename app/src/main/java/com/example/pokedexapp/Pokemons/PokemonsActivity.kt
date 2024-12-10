package com.example.pokedexapp.Pokemons

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.pokedexapp.navigation.Navigation
import com.example.pokedexapp.ui.theme.PokedexAppTheme

class PokemonsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PokedexAppTheme {
                Navigation()
            }
        }
    }
}