package com.example.hotelapplication.ui.commonComponents.Buttons

import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.hotelapplication.R
import com.example.hotelapplication.extentions.singleClick
import com.example.hotelapplication.ui.theme.MainColor
import com.example.hotelapplication.ui.theme.SecondColor
import com.example.hotelapplication.ui.theme.TextSecondColor

enum class CommonButtonsState() {
    TYPE_1,
    TYPE_2
}

@Composable
fun CommonButton(
    title: String,
    onClick: () -> Unit,
    buttonType: CommonButtonsState = CommonButtonsState.TYPE_1,
    modifier: Modifier = Modifier
) {
    when (buttonType) {
        CommonButtonsState.TYPE_1 -> {
            Button(
                modifier = modifier,
                onClick = singleClick(onClick),
                shape = RoundedCornerShape(20),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MainColor
                )
            ) {
                Text(
                    fontWeight = FontWeight.Bold,
                    text = title,
                    fontSize = 10.sp,
                    color = colorResource(R.color.white),
                )
            }
        }

        CommonButtonsState.TYPE_2 -> {
            Button(
                onClick = singleClick(onClick),
                shape = RoundedCornerShape(20),
                colors = ButtonDefaults.buttonColors(
                    containerColor = SecondColor
                ),
                modifier = modifier,
            ) {
                Text(
                    fontWeight = FontWeight.Bold,
                    text = title,
                    fontSize = 10.sp,
                    color = TextSecondColor,
                )
            }
        }
    }
}

@Preview
@Composable
fun CommonButtonPreview() {
    MaterialTheme {
        CommonButton(
            title = "SampleButton",
            buttonType = CommonButtonsState.TYPE_1,
            onClick = {}
        )
    }
}

@Preview
@Composable
fun CommonButtonType2Preview() {
    MaterialTheme {
        CommonButton(title = "SampleButton",
            buttonType = CommonButtonsState.TYPE_2,
            onClick = {}
        )
    }
}