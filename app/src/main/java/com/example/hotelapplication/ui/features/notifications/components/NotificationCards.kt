package com.example.hotelapplication.ui.features.notifications.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hotelapplication.R


@Composable
fun NotificationsCard ( notificationType: NotificationType){

    val icon = painterResource(id = notificationType.iconResId)
    val subject = stringResource(id = notificationType.subjectResId)
    val content = stringResource(id = notificationType.contentResId)
    Row(
        modifier = Modifier
            .width(372.dp)
            .height(110.dp)
            .clip(
                RoundedCornerShape(
                    11.79.dp
                )
            )
            .background(color = colorResource(id = R.color.gray_e3e3e4))
    ) {
        Icon(
            painter = icon,
            contentDescription = "null",
            modifier = Modifier
                .size(80.dp)
                .padding(10.dp)
        )
        Column(modifier = Modifier
            .padding(10.dp)
            .weight(1f)) {
            Text(text = subject
                , fontWeight = FontWeight(600)
                , fontSize = 15.sp)
            Text(text = content
                , fontWeight = FontWeight(500)
                , fontSize = 13.sp
            , modifier = Modifier.padding(top = 10.dp))

        }
    }
}

@Preview
@Composable
fun cardNotificationsPreview() {
    NotificationsCard(NotificationType.PasswordChange)
}
