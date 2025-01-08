package com.example.hotelapplication.ui.features.main

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    Text(
        text = "This is main screen"
    )

}

@Preview
@Composable
fun Prev_Main(){
    MainScreen()
}