package com.example.hotelapplication.ui.commonComponents.Texts

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import com.example.hotelapplication.R
import com.example.hotelapplication.extentions.fontDimensionResource

@Composable
fun TextPlaceholder(text: String) {
    Text(
        text = text,
        color = colorResource(R.color.dark_gray),
        fontSize = fontDimensionResource(R.dimen._13_sp),
        fontWeight = FontWeight.Light,
        fontStyle = FontStyle.Italic
    )
}