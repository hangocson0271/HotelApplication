package com.example.hotelapplication.ui.commonComponents.Images

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hotelapplication.R

@Composable
fun UserAvatar(onClick: () -> Unit) {
    Image(
        painter = painterResource(R.drawable.ic_user),
        contentDescription = "",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(32.dp)
            .clip(CircleShape)                       // clip to the circle shape
            .border(1.dp, color = colorResource(R.color.main_color), CircleShape)
            .clickable(
                enabled = true, onClickLabel = "Clickable image", onClick = onClick
            )
    )
}

@Preview
@Composable
fun PreviewUserAvatar() {
    UserAvatar {}
}