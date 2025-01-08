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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hotelapplication.R
import com.example.hotelapplication.extentions.singleClick
import com.example.hotelapplication.ui.theme.MainColor

@Composable
fun CommonButton(
    title: String,
    bgColor: Color = colorResource(R.color.main_color),
    txtColor: Color = Color.White,
    onClick: () -> Unit
) {
    Button(
        onClick = singleClick(onClick),
        shape = RoundedCornerShape(20),
        colors = ButtonDefaults.buttonColors(
            containerColor = bgColor
        )
    ) {
        Text(
            text = title,
            color = txtColor,
            modifier = Modifier.padding(vertical = 31.dp, horizontal = 40.dp),
        )
    }
}

@Preview
@Composable
fun CommonButtonPreview() {
    MaterialTheme {
        CommonButton(title = "SampleButton") {}
    }
}