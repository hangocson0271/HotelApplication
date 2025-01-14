package com.example.hotelapplication.ui.features.booking

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

import androidx.navigation.NavController
import com.example.hotelapplication.R
import com.example.hotelapplication.ui.commonComponents.DatePicker.CustomDateRangePicker
import com.example.hotelapplication.ui.theme.MainColor

@Composable
fun BookingFormFirstPageScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxHeight(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        CustomDateRangePicker()

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            horizontalArrangement = Arrangement.SpaceAround,
        ) {

        }

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

                Text(text = stringResource(id = R.string.txt_continue))
            }
        }
    }
}
