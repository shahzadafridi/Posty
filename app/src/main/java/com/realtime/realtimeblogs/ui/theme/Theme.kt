package com.realtime.realtimeblogs.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = Posty300,
    primaryVariant = Posty700,
    onPrimary = Color.Black,
    secondary = Posty300,
    onSecondary = Color.Black,
    error = Posty200,
    background = Color.Black
)

private val LightColorPalette = lightColors(
    primary = Posty700,
    primaryVariant = Posty900,
    onPrimary = Color.White,
    secondary = Posty700,
    secondaryVariant = Posty900,
    onSecondary = Color.White,
    error = Posty800,
    background = Color.White
)

@Composable
fun PostyTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = PostyTypography,
        shapes = Shapes,
        content = content
    )
}
