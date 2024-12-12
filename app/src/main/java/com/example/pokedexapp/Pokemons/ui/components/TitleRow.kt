package com.example.pokedexapp.Pokemons.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pokedexapp.R

@Composable
fun TitleRow() {
    Row(
        modifier = Modifier
            .width(328.dp)
            .height(32.dp)
            .background(color = Color.Transparent)
    ) {

        Icon(
            painter = painterResource(id = R.drawable.pokeball),
            contentDescription = "Pokeball",
            modifier = Modifier
                .size(24.dp)
                .align(alignment = Alignment.CenterVertically),
            tint = Color.White
        )

        Spacer(modifier = Modifier.width(16.dp))

        Text(
            text = stringResource(id = R.string.pokemons_screen_title),
            color = Color.White,
            modifier = Modifier
                .width(106.dp)
                .height(32.dp),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            lineHeight = 32.sp
        )
    }
}

@Composable
@Preview
fun TitleRowPreview() {
    TitleRow()
}