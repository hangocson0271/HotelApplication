package com.example.hotelapplication.ui.commonComponents.Buttons

import androidx.compose.foundation.Image
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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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
import com.example.hotelapplication.extentions.isAvailable

enum class RoomTypes(val value: Int) {
    SINGLE(0),
    DOUBLE(1),
    SUITE(2);
}

@Composable
fun ElevatedCardRoomScreen(
    roomName: String = "The Royal flush",
    price: Long? = 25000,
    imageResource: Int = R.drawable.screen,
    roomType: Int? = 0,
    isAvailable: Int? = 1,
    isHaveWifi: Int? = 1,
    isHavePool: Int? = 1,
    isHaveBreakfast: Int? = 1,
    isHaveGym: Int? = 1,
    isHaveBar: Int? = 1,
    onClick: () -> Unit
) {
    val roomTypeString = when (roomType) {
        RoomTypes.SINGLE.value -> stringResource(R.string.txt_single)
        RoomTypes.DOUBLE.value -> stringResource(R.string.txt_double)
        RoomTypes.SUITE.value -> stringResource(R.string.txt_suite)
        else -> {stringResource(R.string.txt_single)}
    }
    val roomTypeIcon = when (roomType) {
        RoomTypes.SINGLE.value  -> R.drawable.ic_single_bed
        RoomTypes.DOUBLE.value  -> R.drawable.ic_double_bed
        RoomTypes.SUITE.value -> R.drawable.ic_suite
        else -> {R.drawable.ic_single_bed}
    }
    ElevatedCard(
        colors = CardDefaults.cardColors(
            containerColor = colorResource(R.color.white)
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        ), modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .height(250.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
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
                    .border(0.93.dp, colorResource(R.color.txt_gray), RoundedCornerShape(18.62.dp)),
                contentScale = ContentScale.Crop,
            )
            Spacer(modifier = Modifier.height(5.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = roomName,
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
                    color = Color.Black
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "$price$/${stringResource(R.string.txt_night)}",
                    style = androidx.compose.ui.text.TextStyle(
                        fontSize = 9.87.sp,
                        lineHeight = 10.81.sp
                    ),
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(end = 10.dp)
                        .height(17.59.dp)
                )
            }
            Spacer(modifier = Modifier.height(5.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(roomTypeIcon),
                    contentDescription = "",
                    modifier = Modifier.size(16.dp),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.width(2.dp))
                Text(
                    text = roomTypeString,
                    textAlign = TextAlign.Start,
                    fontSize = 12.69.sp,
                    color = colorResource(R.color.txt_gray),
                    modifier = Modifier.weight(1f)
                )
            }
            Spacer(modifier = Modifier.height(5.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = if (isHaveBreakfast.isAvailable())
                        painterResource(R.drawable.ic_have_breakfast)
                    else painterResource(R.drawable.ic_no_breakfast),
                    contentDescription = "",
                    modifier = Modifier.size(16.dp),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.width(2.dp))
                Text(
                    text = if (isHaveBreakfast.isAvailable())
                        stringResource(R.string.txt_have_breakfast)
                    else stringResource(R.string.txt_no_breakfast),
                    textAlign = TextAlign.Start,
                    fontSize = 12.69.sp,
                    color = colorResource(R.color.txt_gray),
                    modifier = Modifier.weight(1f)
                )
            }
            Spacer(modifier = Modifier.height(5.dp))
            Row(
                modifier = Modifier
                    .width(120.dp)
                    .padding(horizontal = 16.dp)
                    .align(Alignment.Start),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                if(isHaveWifi.isAvailable()){
                    Image(
                        painter = painterResource(R.drawable.ic_wifi),
                        contentDescription = "",
                        modifier = Modifier.size(16.dp),
                        contentScale = ContentScale.Crop
                    )
                }
                if(isHavePool.isAvailable()){
                    Image(
                        painter = painterResource(R.drawable.ic_pool),
                        contentDescription = "",
                        modifier = Modifier.size(16.dp),
                        contentScale = ContentScale.Crop
                    )
                }
                if(isHaveGym.isAvailable()){
                    Image(
                        painter = painterResource(R.drawable.ic_gym),
                        contentDescription = "",
                        modifier = Modifier.size(16.dp),
                        contentScale = ContentScale.Crop
                    )
                }
                if(isHaveBar.isAvailable()){
                    Image(
                        painter = painterResource(R.drawable.ic_bar),
                        contentDescription = "",
                        modifier = Modifier.size(16.dp),
                        contentScale = ContentScale.Crop
                    )
                }
            }
            Spacer(modifier = Modifier.weight(1f))
            Row {
                Button(
                    onClick = { onClick() },
                    colors = ButtonDefaults.buttonColors(colorResource(R.color.main_color)),
                    enabled = (isAvailable.isAvailable())
                ) {
                    Text(stringResource(R.string.txt_book))
                }
            }
        }
    }
}