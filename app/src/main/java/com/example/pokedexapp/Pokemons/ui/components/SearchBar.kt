package com.example.pokedexapp.Pokemons.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pokedexapp.R

@Composable
fun SearchBar(

) {
    var inputSearch by remember {
        mutableStateOf("")
    }

    Row(
        modifier = Modifier
            .width(328.dp)
            .height(32.dp)
    ) {

        CustomTextField(
            modifier = Modifier
                .background(Color.Transparent)
                .width(280.dp)
                .height(32.dp),
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.search),
                    contentDescription = "",
                    tint = colorResource(id = R.color.standard_red),
                    modifier = Modifier
                        .size(16.dp)
                )
            }
        )

        Spacer(modifier = Modifier.width(16.dp))

        Button(
            onClick = {},
            shape = CircleShape,
            contentPadding = PaddingValues(0.dp),
            modifier = Modifier
                .size(32.dp)
                .align(alignment = Alignment.CenterVertically),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White
            )
        ) {
            Icon(
                painter = painterResource(id = R.drawable.tag),
                contentDescription = "",
                modifier = Modifier
                    .size(16.dp),
                tint = colorResource(id = R.color.standard_red)
            )
        }
    }
}

@Preview
@Composable
fun SearchBarPreview() {
    SearchBar()
}