package com.example.pokedexapp

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource

@Composable
fun MainMenu(){

    Column() {
        
        Text(text = stringResource(id = R.string.welcome))
    }

}