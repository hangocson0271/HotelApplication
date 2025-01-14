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

import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.hotelapplication.R
import com.example.hotelapplication.navigation.Route
import com.example.hotelapplication.ui.commonComponents.DatePicker.CustomDateRangePicker
import com.example.hotelapplication.ui.commonComponents.Scene.BaseScene
import com.example.hotelapplication.ui.commonComponents.TextField.DropDownTextField
import com.example.hotelapplication.ui.commonComponents.TextField.NumericTextField
import com.example.hotelapplication.ui.theme.MainColor

@Composable
fun BookingFormFirstPageScreen(navController: NavController) {

    val roomTypeList = listOf("Standard", "Deluxe", "Presidential", "Penthouse")

    BaseScene (navController = navController, titleScene = stringResource(id = R.string.title_booking_form)) {
        Column(
            modifier = Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            CustomDateRangePicker()

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 18.dp, end = 18.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Column {
                    Text(
                        text = stringResource(id = R.string.txt_room_type),
                        style = MaterialTheme.typography.titleMedium,
                        textAlign = TextAlign.Start,
                        modifier = Modifier.padding(bottom = 5.dp)
                    )
                    DropDownTextField(dropDownList = roomTypeList)
                }

                Column {
                    Text(
                        text = stringResource(id = R.string.txt_room_number),
                        style = MaterialTheme.typography.titleMedium,
                        textAlign = TextAlign.Start,
                        modifier = Modifier.padding(bottom = 5.dp)
                    )
                    NumericTextField()
                }
            }

            Column(
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Text(
                    text = stringResource(id = R.string.txt_guest),
                    style = MaterialTheme.typography.titleMedium,
                    textAlign = TextAlign.Start,
                    modifier = Modifier.padding(bottom = 5.dp)
                )
                NumericTextField()
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 18.dp, end = 18.dp),
                horizontalArrangement = Arrangement.SpaceAround,
            ) {

                Text(
                    text = stringResource(id = R.string.txt_total_price, ":"),
                    style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold),
                    modifier = Modifier.align(Alignment.CenterVertically)
                )

                Text(
                    text = stringResource(id = R.string.txt_total_price, "VND"),
                    style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold),
                    modifier = Modifier.align(Alignment.CenterVertically)
                )

                Button(
                    onClick = { navController.navigate(Route.BookingFormSecondPageScreen.route) },
                    modifier = Modifier
                        .width(170.dp)
                        .height(50.dp),
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
}

@Preview(showBackground = true)
@Composable
fun BookingFormPreview() {
    val navController = rememberNavController()
    BookingFormFirstPageScreen(navController = navController)
}
