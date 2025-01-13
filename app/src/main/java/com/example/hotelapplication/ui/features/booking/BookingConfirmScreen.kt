package com.example.hotelapplication.ui.features.booking

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hotelapplication.R
import com.example.hotelapplication.ui.commonComponents.Buttons.ElevatedCardHomeScreen
import com.example.hotelapplication.ui.theme.HotelApplicationTheme
import com.example.hotelapplication.ui.theme.MainColor

@Composable
fun BookingConfirmScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(14.dp),
    ) {

        /* Upper card information */
        ElevatedCard(
            modifier = Modifier
                .fillMaxHeight(0.2f)
                .fillMaxWidth(),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 2.dp
            ),
            shape = RoundedCornerShape(15.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceContainerLowest)
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 15.dp, end = 15.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = stringResource(id = R.string.txt_name),
                        style = MaterialTheme.typography.titleMedium,
                        textAlign = TextAlign.Start
                    )

                    Text(
                        text = stringResource(id = R.string.txt_name),
                        style = MaterialTheme.typography.titleLarge,
                        textAlign = TextAlign.End
                    )
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 15.dp, end = 15.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = stringResource(id = R.string.txt_email),
                        style = MaterialTheme.typography.titleMedium,
                        textAlign = TextAlign.Start
                    )

                    Text(
                        text = stringResource(id = R.string.txt_email),
                        style = MaterialTheme.typography.titleLarge,
                        textAlign = TextAlign.End
                    )
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 15.dp, end = 15.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = stringResource(id = R.string.txt_phone),
                        style = MaterialTheme.typography.titleMedium,
                        textAlign = TextAlign.Start
                    )

                    Text(
                        text = stringResource(id = R.string.txt_phone),
                        style = MaterialTheme.typography.titleLarge,
                        textAlign = TextAlign.End
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(18.dp))


        /* Center card information */
        ElevatedCard(
            modifier = Modifier
                .fillMaxHeight(0.85f)
                .fillMaxWidth(),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 2.dp
            ),
            shape = RoundedCornerShape(15.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceContainerLowest)
        ) {
            Column {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    ElevatedCardHomeScreen { }
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp),
                    horizontalArrangement = Arrangement.Absolute.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = stringResource(id = R.string.txt_check_in),
                        style = MaterialTheme.typography.titleLarge,
                        textAlign = TextAlign.Center
                    )

                    Text(
                        text = stringResource(id = R.string.txt_check_out),
                        style = MaterialTheme.typography.titleLarge,
                        textAlign = TextAlign.Center
                    )
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Absolute.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "01/01/2025",
                        style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.SemiBold),
                        textAlign = TextAlign.Center
                    )

                    Text(
                        text = "28/01/2025",
                        style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.SemiBold),
                        textAlign = TextAlign.Center
                    )
                }

                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 15.dp, end = 15.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = stringResource(id = R.string.txt_room_type),
                            style = MaterialTheme.typography.titleMedium,
                            textAlign = TextAlign.Start
                        )

                        Text(
                            text = stringResource(id = R.string.txt_room_type),
                            style = MaterialTheme.typography.titleLarge,
                            textAlign = TextAlign.End
                        )
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 15.dp, end = 15.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = stringResource(id = R.string.txt_guest),
                            style = MaterialTheme.typography.titleMedium,
                            textAlign = TextAlign.Start
                        )

                        Text(
                            text = stringResource(id = R.string.txt_guest),
                            style = MaterialTheme.typography.titleLarge,
                            textAlign = TextAlign.End
                        )
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 15.dp, end = 15.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = stringResource(id = R.string.txt_room_number),
                            style = MaterialTheme.typography.titleMedium,
                            textAlign = TextAlign.Start
                        )

                        Text(
                            text = stringResource(id = R.string.txt_room_number),
                            style = MaterialTheme.typography.titleLarge,
                            textAlign = TextAlign.End
                        )
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 15.dp, end = 15.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = stringResource(id = R.string.txt_total_price),
                            style = MaterialTheme.typography.titleMedium,
                            textAlign = TextAlign.Start
                        )

                        Text(
                            text = stringResource(id = R.string.txt_total_price),
                            style = MaterialTheme.typography.titleLarge,
                            textAlign = TextAlign.End
                        )
                    }
                }
            }
        }



        /* Confirm button */
        Spacer(modifier = Modifier.height(18.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            horizontalArrangement = Arrangement.SpaceAround,
        ) {
            Button(
                onClick = { /* TODO: Handle button click*/ },
                modifier = Modifier
                    .padding(horizontal = 4.dp)
                    .width(250.dp)
                    .height(50.dp)
                    .align(Alignment.CenterVertically),
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MainColor
                ),
            ) {

                Text(text = stringResource(id = R.string.txt_confirm_booking))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BookingConfirmPreview() {
    HotelApplicationTheme {
        BookingConfirmScreen()
    }
}