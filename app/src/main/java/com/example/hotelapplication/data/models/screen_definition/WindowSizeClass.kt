package com.example.hotelapplication.data.models.screen_definition

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalConfiguration

data class WindowSizeClass(
    val platform: ScreenMode, val width: Int, val height: Int
)

private fun determinePlatform(width: Int): ScreenMode = when {
    width >= 1080 -> ScreenMode.ExtendMode
    else -> ScreenMode.StandardMode
}

@Composable
fun rememberWindowSizeClass(): WindowSizeClass {
    val config = LocalConfiguration.current
    val width by remember { mutableIntStateOf(config.screenWidthDp) }
    val height by remember { mutableIntStateOf(config.screenHeightDp) }

    return WindowSizeClass(
        platform = determinePlatform(width), width = width, height = height
    )
}