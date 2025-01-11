package com.example.hotelapplication.ui.commonComponents.Buttons

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hotelapplication.R
import com.example.hotelapplication.extentions.singleClick

@Composable
fun ElevatedCardHomeScreen(
    hotelName: String = "The Pheels",
    rating: String = "4.5",
    location: String = "Ajah, Lagos",
    price: String = "25,000",
    imageResource: Int = R.drawable.screen,
    onClick: () -> Unit
) {
    ElevatedCard(
        onClick = singleClick(onClick), elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp // Tăng độ nổi
        ), modifier = Modifier
            .size(
                width = 206.85.dp, height = 171.dp
            )
            .padding(16.dp)
            .background(color = Color.White)
    ) {
        Column {
            Image(
                painter = painterResource(imageResource),
                contentDescription = null,
                modifier = Modifier
                    .height(
                        99.26.dp
                    )
                    .width(198.17.dp)
                    .padding(top = 10.dp, start = 5.dp , end = 5.dp , bottom = 10.dp)
                    .clip(RoundedCornerShape(18.62.dp))
                    .border(0.93.dp, Color(0xFFB8B8B9), RoundedCornerShape(18.62.dp)),
                contentScale = ContentScale.Crop,
            )

            // Row chứa Text và Icon ngôi sao
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                // hotel name
                Text(
                    text = hotelName,
                    modifier = Modifier.padding(start = 8.dp),
                    textAlign = TextAlign.Start,
                    fontFamily = FontFamily.Cursive,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Color.Black // Màu chữ trắng
                )
                // Spacer đẩy phần tử sang phải
                Spacer(modifier = Modifier.weight(1f))
                // icon rating
                Icon(
                    imageVector = Icons.Filled.Star,
                    contentDescription = "Star Icon",
                    modifier = Modifier.padding(end = 8.dp),
                    tint = Color.Yellow
                )
                //rating
                Text(
                    text = rating,
                    modifier = Modifier.padding(end = 8.dp),
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Color.White
                )
            }

            // Address
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(1.dp)
                    .background(color = Color(0xFFEDE0D4))
                    .clip(RoundedCornerShape(8.dp)),
                horizontalArrangement = Arrangement.SpaceBetween // Điều chỉnh vị trí địa chỉ
            ) {
                //icon location
                Icon(
                    imageVector = Icons.Filled.LocationOn,
                    contentDescription = "Location Icon",
                    modifier = Modifier.padding(start = 1.dp),
                    tint = Color.Blue
                )
                Text(
                    text = location,
                    textAlign = TextAlign.Start,
                    fontSize = 18.sp,
                    color = Color.Black,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }

            // Price
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                horizontalArrangement = Arrangement.End // Căn phải cho giá
            ) {
                Text(
                    text = "NGN $price/night",
                    fontSize = 9.87.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(end = 10.dp)
                )
            }
        }
    }
}


@Preview
@Composable
fun CardMainScreenPreview() {
    MaterialTheme {
        ElevatedCardHomeScreen(onClick = {

        })
    }
}
