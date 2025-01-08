package com.example.hotelapplication.ui.commonComponents.Buttons

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hotelapplication.extentions.singleClick
import com.example.hotelapplication.ui.theme.PurpleGrey80

@Composable
fun HotelButtonSample(title: String, onClick: () -> Unit) {
    Button(
        onClick = singleClick(onClick),
        shape = RoundedCornerShape(16),
        colors = ButtonDefaults.buttonColors(
            containerColor = PurpleGrey80
        )
    ) {
        Text(
            text = title,
            color = Color.White,
            modifier = Modifier.padding(vertical = 31.dp, horizontal = 40.dp),
        )
    }
}

@Preview
@Composable
fun HotelButtonSamplePreview() {
    MaterialTheme {
        HotelButtonSample(title = "SampleButton") {}
    }
}