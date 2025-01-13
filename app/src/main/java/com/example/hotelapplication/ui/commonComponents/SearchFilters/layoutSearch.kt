package com.example.hotelapplication.ui.commonComponents.SearchFilters

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hotelapplication.R

@Composable
fun LayoutSearch(
    modifier: Modifier = Modifier,
    isSearchable: Boolean,
    onClick: () -> Unit = {},
    percentFillWidth: Float = 0.8f,
) {
    Row(
        modifier = modifier
            .fillMaxWidth(percentFillWidth)
            .clip(RoundedCornerShape(20))
            .background(colorResource(R.color.gray_e3e3e4))
            .clickable(enabled = true, onClick = {
                onClick()
            })
            .padding(5.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        var text by remember { mutableStateOf("") }

        BasicTextField(
            enabled = isSearchable,
            value = text,
            onValueChange = {
                text = it
            },
            textStyle = LocalTextStyle.current.copy(
                fontSize = 16.sp
            ),
            decorationBox = { innerTextField ->
                if (text.isEmpty()) {
                    Text(
                        text = stringResource(R.string.search_hint),
                        color = Color.Gray,
                        fontSize = 16.sp
                    )
                }
                innerTextField()
            },
            singleLine = true
        )
        Image(
            painter = painterResource(R.drawable.ic_search),
            contentDescription = "",
            alignment = Alignment.CenterEnd,
            modifier = Modifier
                .padding(end = 10.dp)
                .size(24.dp)

        )
    }
}

@Composable
fun ButtonFilter(onClick: () -> Unit = {}) {
    Image(
        painter = painterResource(R.drawable.ic_filter),
        contentDescription = "",
        modifier = Modifier
            .padding(5.dp)
            .border(
                BorderStroke(0.5.dp, Color.Gray),
                RectangleShape
            )
            .padding(5.dp)
    )
}

@Preview
@Composable
fun PreviewLayoutSearch() {
    LayoutSearch(isSearchable = true)
}

@Preview
@Composable
fun PreviewButtonFilter() {
    ButtonFilter()
}