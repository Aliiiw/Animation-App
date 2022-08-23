package com.alirahimi.borutoapp.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.material.Colors
import androidx.compose.ui.graphics.Color

val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)

val mainColor = Color(36, 47, 155)
val mainColor2 = Color(110, 111, 212)
val mainColor3 = Color(155, 163, 235)
val mainColor4 = Color(219, 223, 253)


val LightGray = Color(0xFFD8D8D8)
val DarkGray = Color(0xFF2A2A2A)

val Colors.welcomeScreenBackgroundColor
    @Composable
    get() = if (isLight) Color.White else Color.Black


val Colors.titleColor
    @Composable
    get() = if (isLight) DarkGray else LightGray


val Colors.descriptionColor
    @Composable
    get() = if (isLight) DarkGray.copy(alpha = 0.5f) else LightGray.copy(alpha = 0.5f)


val Colors.activeIndicatorColor
    @Composable
    get() = if (isLight) mainColor else mainColor4


val Colors.inActiveIndicatorColor
    @Composable
    get() = if (isLight) LightGray else DarkGray


val Colors.buttonBackgroundColor
    @Composable
    get() = if (isLight) mainColor else mainColor4