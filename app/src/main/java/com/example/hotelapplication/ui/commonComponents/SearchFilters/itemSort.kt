package com.example.hotelapplication.ui.commonComponents.SearchFilters

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hotelapplication.R
import com.example.hotelapplication.extentions.singleClick

@Composable
fun ItemSort(title: String) {
    var selectedState = remember { mutableStateOf(false) }
    OutlinedButton(
        onClick = singleClick { },
        border = BorderStroke(1.dp, colorResource(R.color.main_color)),
        shape = RoundedCornerShape(50),
        colors = ButtonDefaults.outlinedButtonColors(contentColor = colorResource(R.color.main_color))
    ) {
        Text(
            fontWeight = FontWeight.Bold,
            text = title
        )
    }
}

@Preview
@Composable
fun PreviewItemSort() {
    ItemSort("Test")
}