package com.example.hotelapplication.ui.commonComponents.Buttons

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.Start
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hotelapplication.R
import com.example.hotelapplication.extentions.singleClick

enum class BookingStatus{
    NORMAL,COMPLETED,CANCELLED
}

@Composable
fun CardUpComingBookScreen(
    hotelName: String = "The Good House",
    location: String = "Estate, Lagos",
    price: String = "25,000",
    bookingStatus: BookingStatus = BookingStatus.NORMAL,
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
    .fillMaxWidth()
    .height(171.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Start
        ) {
            Row {
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
                Column(
                    modifier = Modifier
                        .height(100.dp)
                        .fillMaxWidth(),
                    horizontalAlignment = Start,
                    verticalArrangement = Arrangement.Center
                ){
                    Row(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = hotelName,
                            modifier = Modifier
                                .width(
                                    101.35.dp
                                )
                                .height(17.59.dp),
                            textAlign = TextAlign.Start,
                            fontFamily = FontFamily.Cursive,
                            fontWeight = FontWeight.Bold,
                            fontSize = 15.01.sp,
                            color = Color.Black
                        )
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                    ){
                        Spacer(modifier = Modifier.weight(1f))
                        if(bookingStatus == BookingStatus.COMPLETED ||
                            bookingStatus == BookingStatus.CANCELLED){
                            Image(
                                painter = if(bookingStatus == BookingStatus.COMPLETED)
                                    painterResource(R.drawable.ic_booking_success)
                                else painterResource(R.drawable.ic_warning),
                                contentDescription = "",
                                modifier = Modifier.size(16.dp),
                                contentScale = ContentScale.Crop
                            )
                        }
                        Box(modifier = Modifier.size(16.dp))
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Filled.LocationOn,
                            contentDescription = "",
                            modifier = Modifier.size(16.dp),
                            tint = Color(0xFF238C98)
                        )
                        Text(
                            text = location,
                            textAlign = TextAlign.Start,
                            fontSize = 12.69.sp,
                            color = Color(0x7D303030),
                            modifier = Modifier.weight(1f)
                        )
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Text(
                            text = "$price/\$/${stringResource(R.string.txt_night)}",
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
            Spacer(modifier = Modifier.height(5.dp))
            Column(modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = CenterHorizontally
            ){
                if(bookingStatus == BookingStatus.NORMAL){
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ){
                        OutlinedButton(onClick = { /*TODO*/ }) {
                            Text(text = stringResource(R.string.txt_cancel))
                        }
                        Button(onClick = { /*TODO*/ }) {
                            Text(text = stringResource(R.string.txt_viewbooking))
                        }
                    }
                }
                if(bookingStatus == BookingStatus.COMPLETED){
                    Box(modifier = Modifier
                        .width(200.dp)
                        .height(50.dp)
                        .align(CenterHorizontally)
                        .clip(RoundedCornerShape(10.dp))
                        .background(color = Color(0xFFa7d1d6))
                    ){
                        Text(text = stringResource(R.string.txt_booking_completed),
                            color = Color(0xFF238C98),
                            modifier = Modifier.align(Center))
                    }
                }
                if(bookingStatus == BookingStatus.CANCELLED){
                    Box(modifier = Modifier
                        .width(200.dp)
                        .height(50.dp)
                        .align(CenterHorizontally)
                        .clip(RoundedCornerShape(10.dp))
                        .background(color = Color.White)
                    ) {
                        Text(
                            text = stringResource(R.string.txt_booking_cancel),
                            color = Color.Red,
                            modifier = Modifier.align(Center),
                            fontSize = 12.sp
                        )
                    }
                }
            }
        }
    }
}