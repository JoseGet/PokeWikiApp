package com.example.pokedexapp

import android.app.Application
import com.example.pokedexapp.data.AppContainer
import com.example.pokedexapp.data.DefaultAppContainer

class PokeWikiApplication(): Application() {

    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}