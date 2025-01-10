package com.example.hotelapplication.ui.commonComponents.Texts

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.hotelapplication.R

@Composable
fun TextLoginTitle(
    title: String
) {
    Text(
        text = title,
        fontSize = 36.sp,
        color = colorResource(R.color.main_color),
        style = TextStyle(fontWeight = FontWeight(600))
    )
}