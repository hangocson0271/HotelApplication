package com.example.hotelapplication.ui.commonComponents.Buttons

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hotelapplication.R


@Composable
fun LoginButton(label: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        Modifier
            .height(52.dp)
            .width(304.dp),
        colors = ButtonDefaults.buttonColors(colorResource(R.color.main_color)),
        shape = RoundedCornerShape(14.dp)
    ) {
        Text(text = label, fontSize = 16.sp)
    }
}