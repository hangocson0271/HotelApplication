package com.example.hotelapplication.ui.features.booking

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
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
import com.example.hotelapplication.extentions.hiltViewModel
import com.example.hotelapplication.navigation.Route
import com.example.hotelapplication.ui.commonComponents.DatePicker.CustomDateRangePicker
import com.example.hotelapplication.ui.commonComponents.Scene.BaseScene
import com.example.hotelapplication.ui.theme.MainColor

@Composable
fun BookingFormFirstPageScreen(navController: NavController, roomId: Int = 0) {

    val roomTypeList = listOf(stringResource(R.string.txt_single), stringResource(R.string.txt_double), stringResource(R.string.txt_suite))
    val bookingViewModel = hiltViewModel<BookingScreenViewModel>()

    var checkInDate by remember { mutableStateOf("") }
    var checkOutDate by remember { mutableStateOf("") }
    var daysBetween by remember { mutableLongStateOf(0) }

    BaseScene (navController = navController, titleScene = stringResource(id = R.string.title_booking_form)) {

        val roomType by rememberSaveable { mutableStateOf("") }

        Column(
            modifier = Modifier
                .fillMaxHeight()
                .scrollable(state = rememberScrollState(), orientation = Orientation.Vertical),
            verticalArrangement = Arrangement.SpaceBetween,
        ) {
            CustomDateRangePicker(
                onValueChange = { checkIn, checkOut, days ->
                    checkInDate = checkIn
                    checkOutDate = checkOut
                    daysBetween = days
                    bookingViewModel.setValues(checkInDate, checkOutDate, daysBetween)
                }
            )


            Column(modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 18.dp, end = 18.dp),
                verticalArrangement = Arrangement.SpaceAround,
                horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = stringResource(id = R.string.txt_room_type),
                    style = MaterialTheme.typography.titleMedium,
                    textAlign = TextAlign.Start,
                    modifier = Modifier
                        .padding(bottom = 5.dp)
                )
                OutlinedTextField(
                    value = stringResource(R.string.txt_single),
                    onValueChange = {},
                    modifier = Modifier
                        .width(150.dp),
                    singleLine = true,
                    readOnly = true
                )
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
                    text = "${200 * daysBetween}",
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
                    enabled = checkInDate.isNotEmpty() && checkOutDate.isNotEmpty()
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
