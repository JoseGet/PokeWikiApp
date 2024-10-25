package com.example.pokedexapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pokedexapp.Home.ui.HomePage
import com.example.pokedexapp.PokemonsScreen.ui.PokemonsScreen
import com.example.pokedexapp.navigation.routes.HomePageRoutes

@Composable
fun Navigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = HomePageRoutes.Home.name
    ) {
        composable(route = HomePageRoutes.Home.name) {
            HomePage(navController)
        }

        composable(route = HomePageRoutes.Pokemons.name) {
            PokemonsScreen(navController)
        }
    }

}