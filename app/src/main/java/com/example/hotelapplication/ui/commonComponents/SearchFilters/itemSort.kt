package com.example.hotelapplication.ui.commonComponents.SearchFilters

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hotelapplication.R

@Composable
fun ItemSort(
    image: Painter? = null,
    title: String,
    isSelected: Boolean
) {
    var selectedState by remember { mutableStateOf(isSelected) }

    if (selectedState) {
        Button(
            onClick = {
                selectedState = !selectedState
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(R.color.main_color)
            ),
            modifier = Modifier
                .wrapContentSize()
        ) {
            image?.let {
                Image(
                    modifier = Modifier
                        .size(20.dp),
                    painter = image,
                    contentDescription = null,
                )
                Spacer(modifier = Modifier.width(5.dp))
            }
            Text(
                color = colorResource(R.color.white),
                fontWeight = FontWeight.Bold,
                text = title,
                fontSize = 10.sp,
            )
        }
    } else {
        OutlinedButton(
            onClick = { selectedState = !selectedState },
            border = BorderStroke(1.dp, colorResource(R.color.main_color)),
            shape = RoundedCornerShape(50),
            colors = ButtonDefaults.outlinedButtonColors(contentColor = colorResource(R.color.main_color)),
            modifier = Modifier
                .wrapContentSize()
        ) {
            image?.let {
                Image(
                    modifier = Modifier
                        .size(20.dp),
                    painter = image,
                    contentDescription = null,
                )
                Spacer(modifier = Modifier.width(5.dp))
            }
            Text(
                fontWeight = FontWeight.Bold,
                text = title,
                fontSize = 10.sp,
            )
        }
    }
}

@Preview
@Composable
fun PreviewItemSortFalse() {
    ItemSort(title = "Test", isSelected = false)
}

@Preview
@Composable
fun PreviewItemSortTrue() {
    ItemSort(title = "Test", isSelected = true)
}

@Preview
@Composable
fun PreviewItemSortWithImage() {
    ItemSort(
        title = "Test",
        isSelected = true,
        image = painterResource(R.drawable.ic_star)
    )
}