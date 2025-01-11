package com.example.hotelapplication.ui.features.splash.views

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit

@Composable
fun SplashText(
    text: String,
    fontSize: TextUnit = TextUnit.Unspecified,
    color: Color = Color.White
) {
    Text(
        text,
        color = color,
        fontSize = fontSize,
        fontWeight = FontWeight.Bold
    )
}