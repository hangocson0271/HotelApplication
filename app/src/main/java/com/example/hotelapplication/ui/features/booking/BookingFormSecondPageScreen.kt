package com.example.hotelapplication.ui.features.booking

import androidx.compose.foundation.gestures.Orientation
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
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.hotelapplication.R
import com.example.hotelapplication.extentions.hiltViewModel
import com.example.hotelapplication.navigation.Route
import com.example.hotelapplication.ui.commonComponents.Scene.BaseScene
import com.example.hotelapplication.ui.commonComponents.TextField.NumericTextField
import com.example.hotelapplication.ui.theme.MainColor

@Composable
fun BookingFormSecondPageScreen(navController: NavController) {

    val bookingViewModel = hiltViewModel<BookingScreenViewModel>()

    var notesInput by rememberSaveable { mutableStateOf("") }

    BaseScene (navController = navController, titleScene = stringResource(id = R.string.title_booking_form)) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(18.dp)
                .scrollable(state = rememberScrollState(), orientation = Orientation.Vertical),
            verticalArrangement = Arrangement.SpaceBetween
        ){
//            Row(
//                modifier = Modifier
//                    .fillMaxWidth(),
//                horizontalArrangement = Arrangement.SpaceBetween,
//            ) {
                // Username
            Column {
                Text(
                    text = stringResource(id = R.string.txt_username),
                    style = MaterialTheme.typography.titleMedium,
                    textAlign = TextAlign.Start,
                    modifier = Modifier.padding(bottom = 5.dp)
                )

                OutlinedTextField(
                    value = bookingViewModel.userName.collectAsState().value,
                    onValueChange = {},
                    modifier = Modifier
                        .fillMaxWidth(),
                    singleLine = true,
                    readOnly = true
                )

            }

                // Surname
//                Column {
//                    Text(
//                        text = stringResource(id = R.string.txt_surname),
//                        style = MaterialTheme.typography.titleMedium,
//                        textAlign = TextAlign.Start,
//                        modifier = Modifier.padding(bottom = 5.dp)
//                    )
//                    OutlinedTextField(
//                        value = surnameInput,
//                        onValueChange = {
//                            surnameInput = it
//                        },
//                        modifier = Modifier
//                            .width(150.dp),
//                        singleLine = true,
//                    )
//                }
//            }

            // Email
            Column {
                Text(
                    text = stringResource(id = R.string.txt_email),
                    style = MaterialTheme.typography.titleMedium,
                    textAlign = TextAlign.Start,
                    modifier = Modifier.padding(bottom = 5.dp)
                )
                OutlinedTextField(
                    value = bookingViewModel.email.collectAsState().value,
                    onValueChange = {},
                    modifier = Modifier
                        .fillMaxWidth(),
                    singleLine = true,
                    readOnly = true
                )
            }

            // Phone
            Column {
                Text(
                    text = stringResource(id = R.string.txt_phone),
                    style = MaterialTheme.typography.titleMedium,
                    textAlign = TextAlign.Start,
                    modifier = Modifier.padding(bottom = 5.dp)
                )
                OutlinedTextField(
                    value = bookingViewModel.phone.collectAsState().value,
                    onValueChange = {},
                    modifier = Modifier
                        .fillMaxWidth(),
                    singleLine = true,
                    readOnly = true,
                )
            }

            // Notes
            Column {
                Text(
                    text = stringResource(id = R.string.txt_notes),
                    style = MaterialTheme.typography.titleMedium,
                    textAlign = TextAlign.Start,
                    modifier = Modifier.padding(bottom = 5.dp)
                )
                OutlinedTextField(
                    value = notesInput,
                    onValueChange = {
                        notesInput = it
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(TextFieldDefaults.MinHeight * 3)
                )
            }

            Button(
                onClick = {
                    bookingViewModel.setNoteValue(notesInput)
                    navController.navigate(Route.CancellationPolicyScreen.route)
                },
                modifier = Modifier
                    .width(250.dp)
                    .height(50.dp)
                    .align(Alignment.CenterHorizontally),
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

@Preview(showBackground = true)
@Composable
fun BookingFormSecondPreview() {
    val navController = rememberNavController()
    BookingFormSecondPageScreen(navController = navController)
}