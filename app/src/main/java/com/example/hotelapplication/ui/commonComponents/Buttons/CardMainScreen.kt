package com.example.hotelapplication.ui.commonComponents.Buttons

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
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
        colors = CardDefaults.cardColors(
            containerColor = colorResource(R.color.white)
        ),
        onClick = singleClick(onClick), elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        ), modifier = Modifier
            .padding(10.dp)
            .size(
                width = 206.85.dp, height = 171.dp
            )
            //.background(color = Color(0x6B86B340))
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(imageResource),
                contentDescription = null,
                modifier = Modifier
                    .height(
                        99.26.dp
                    )
                    .width(198.17.dp)
                    .padding(5.dp)
                    .clip(RoundedCornerShape(18.62.dp))
                    .border(0.93.dp, Color(0xFFB8B8B9), RoundedCornerShape(18.62.dp)),
                contentScale = ContentScale.Crop,
            )

            // Row chứa Text và Icon ngôi sao
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                // hotel name
                Text(
                    text = hotelName,
                    modifier = Modifier
                        .padding(
                            start = 18.97.dp
                        )
                        .width(
                            101.35.dp
                        )
                        .height(17.59.dp),
                    textAlign = TextAlign.Start,
                    fontFamily = FontFamily.Cursive,
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.01.sp,
                    color = Color.Black // Màu chữ trắng
                )
                // Spacer đẩy phần tử sang phải
                Spacer(modifier = Modifier.weight(1f))
                // icon rating
                Icon(
                    imageVector = Icons.Filled.Star,
                    contentDescription = "Star Icon",
                    tint = Color(0xFCD061E5)
                )
                //rating
                Text(
                    text = rating,
                    modifier = Modifier.padding(end = 10.dp),
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    fontSize = 10.22.sp,
                    color = Color(0xFF000000)
                )
            }
// Address
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Icon location
                Icon(
                    imageVector = Icons.Filled.LocationOn,
                    contentDescription = "Location Icon",
                    modifier = Modifier.size(16.dp),
                    tint = Color(0xFF238C98)
                )
                // Text location
                Text(
                    text = location,
                    textAlign = TextAlign.Start,
                    fontSize = 12.69.sp,
                    color = Color(0x7D303030),
                    modifier = Modifier.weight(1f)
                )
            }

            // Price
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                Text(
                    text = "NGN $price/night",
                    style = androidx.compose.ui.text.TextStyle(
                        fontSize = 9.87.sp,
                        lineHeight = 10.81.sp
                    ),
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(end = 10.dp)
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
