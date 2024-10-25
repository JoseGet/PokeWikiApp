package com.example.pokedexapp.Home

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.pokedexapp.Home.ui.HomePage
import com.example.pokedexapp.R
import com.example.pokedexapp.ui.theme.PokedexAppTheme

class HomePageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            PokedexAppTheme {
                HomePage()
            }
        }
    }
}