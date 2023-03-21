package com.example.superheroesapp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle

private val DarkColorPalette = darkColors(
    background = Cyan900,
    surface = Cyan700,
    onSurface = White,
    primary = Grey900,
    onPrimary = White,
    secondary = Grey100,
    primaryVariant = PurpleClear
)

private val LightColorPalette = lightColors(
    background = screenBackground,

    //BoxColor Default
    surface = boxDefault,
    //FontColor Default
    onSurface = fontColorDefault,

    //BoxColor on Selected
    primary = boxSelected,
    //FontColor on Selected
    onPrimary = fontColorSelected,

    //Arrow
    secondary = Grey900

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun SuperHeroTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = com.example.superheroesapp.ui.theme.Typography,
        shapes = Shapes,
        content = content
    )
}