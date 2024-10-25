package com.example.pokedexapp.PokemonsScreen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.pokedexapp.PokemonsScreen.ui.PokemonsScreen
import com.example.pokedexapp.navigation.Navigation
import com.example.pokedexapp.ui.theme.PokedexAppTheme

class MainActivity : ComponentActivity() {
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