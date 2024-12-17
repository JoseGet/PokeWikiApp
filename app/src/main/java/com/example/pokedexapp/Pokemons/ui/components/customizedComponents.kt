package com.example.pokedexapp.Pokemons.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun CustomTextField(
    modifier: Modifier = Modifier,
    leadingIcon: (@Composable () -> Unit)? = null,
    trailingIcon: (@Composable () -> Unit)? = null,
    placeholderText: String = "Placeholder",
    //fontSize: TextUnit = MaterialTheme.typography.bodyMedium.fontSize
) {
    var text by rememberSaveable { mutableStateOf("") }
    BasicTextField(
        modifier = modifier
            .background(
                MaterialTheme.colorScheme.surface,
                MaterialTheme.shapes.small,
            )
            .fillMaxWidth(),
        value = text,
        onValueChange = {
            text = it
        },
        singleLine = true,
        cursorBrush = SolidColor(MaterialTheme.colorScheme.primary),
        textStyle = LocalTextStyle.current.copy(
            color = MaterialTheme.colorScheme.onSurface,
        ),
        decorationBox = { innerTextField ->
            Row(
                modifier,
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (leadingIcon != null) leadingIcon()

                Box(Modifier.weight(1f)) {
                    if (text.isEmpty()) {
                        Text(
                            text = placeholderText,
                            style = LocalTextStyle.current.copy(
                                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.3f),
                            )
                        )
                    }
                    innerTextField()
                }
                if (trailingIcon != null) trailingIcon()
            }
        }
    )
}

@Preview
@Composable
fun CustomTextFieldPreview() {
    CustomTextField(
        modifier = Modifier,
        leadingIcon = {},
        trailingIcon = {},
        placeholderText = "Search",
    )
}