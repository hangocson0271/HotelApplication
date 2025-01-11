package com.example.hotelapplication.ui.commonComponents.Buttons

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.hotelapplication.R

@Composable
fun OutLineImageButton(
    painter: Painter,
    onClick: () -> Unit,
) {
    OutlinedButton (
        onClick = onClick,
        border = BorderStroke(1.dp, color = colorResource(R.color.main_color)),
        shape = RoundedCornerShape(12.dp)
    ) {
        Image(
            painter,
            contentDescription = ""
        )
    }
}