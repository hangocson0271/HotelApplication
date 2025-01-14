package com.example.hotelapplication.ui.commonComponents.Buttons

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hotelapplication.R

@SuppressLint("ResourceAsColor")
@Composable
fun PaymentButton(label: String, onClick: () -> Unit, modifier: Modifier) {
    Button(
        onClick = onClick,
        modifier = modifier
            .height(50.dp)
            .width(250.dp)
            .border(
                width = 0.62.dp,
                color = Color(R.color.borderCardPaymentButton_color),
                shape = RoundedCornerShape(14.dp)
            ),
        colors = ButtonDefaults.buttonColors(colorResource(R.color.main_color)),
        shape = RoundedCornerShape(14.dp)
    ) {
        Text(text = label, fontSize = 16.sp)
    }
}

@Preview
@Composable
fun PaymentButtonPreview() {
    PaymentButton(label = "Continue", onClick = {
        Log.i("PaymentButton", "onClick")
    } , modifier = Modifier)
}

