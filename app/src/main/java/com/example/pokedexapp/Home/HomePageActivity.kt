package com.example.pokedexapp.Home

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.example.pokedexapp.navigation.Navigation
import com.example.pokedexapp.ui.theme.PokedexAppTheme

class HomePageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            PokedexAppTheme {
                Navigation()
            }
        }
    }
}