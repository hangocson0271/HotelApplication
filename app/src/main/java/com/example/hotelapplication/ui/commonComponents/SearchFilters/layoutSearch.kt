package com.example.hotelapplication.ui.commonComponents.SearchFilters

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hotelapplication.R
import com.example.hotelapplication.extentions.singleClick

@Composable
fun LayoutSearch(
    isSearchable: Boolean,
    onClick: () -> Unit = {},
    percentFillWidth: Float = 0.8f,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(percentFillWidth)
            .clip(RoundedCornerShape(20))
            .background(colorResource(R.color.gray_e3e3e4))
            .clickable(enabled = isSearchable, onClick = {
                if (isSearchable) singleClick(onClick)
            })
            .padding(5.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = stringResource(R.string.search_hint),
            color = colorResource(R.color.txt_gray),
            modifier = Modifier
                .padding(10.dp)
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