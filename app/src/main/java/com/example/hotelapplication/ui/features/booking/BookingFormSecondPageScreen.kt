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
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
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
import com.example.hotelapplication.navigation.Route
import com.example.hotelapplication.ui.commonComponents.Scene.BaseScene
import com.example.hotelapplication.ui.commonComponents.TextField.NumericTextField
import com.example.hotelapplication.ui.theme.MainColor

@Composable
fun BookingFormSecondPageScreen(navController: NavController) {

    var firstNameInput by rememberSaveable { mutableStateOf("") }
    var surnameInput by rememberSaveable { mutableStateOf("") }
    var idCardPassportInput by rememberSaveable { mutableStateOf("") }
    var phoneInput by rememberSaveable { mutableStateOf("") }
    var notesInput by rememberSaveable { mutableStateOf("") }

    BaseScene (navController = navController, titleScene = stringResource(id = R.string.title_booking_form)) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(18.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ){
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                // First Name
                Column {
                    Text(
                        text = stringResource(id = R.string.txt_first_name),
                        style = MaterialTheme.typography.titleMedium,
                        textAlign = TextAlign.Start,
                        modifier = Modifier.padding(bottom = 5.dp)
                    )

                    OutlinedTextField(
                        value = firstNameInput,
                        onValueChange = {
                            firstNameInput = it
                        },
                        modifier = Modifier
                            .width(150.dp),
                        singleLine = true,
                    )

                }

                // Surname
                Column {
                    Text(
                        text = stringResource(id = R.string.txt_surname),
                        style = MaterialTheme.typography.titleMedium,
                        textAlign = TextAlign.Start,
                        modifier = Modifier.padding(bottom = 5.dp)
                    )
                    OutlinedTextField(
                        value = surnameInput,
                        onValueChange = {
                            surnameInput = it
                        },
                        modifier = Modifier
                            .width(150.dp),
                        singleLine = true,
                    )
                }
            }

            // ID Card/Passport
            Column {
                Text(
                    text = stringResource(id = R.string.txt_id_card_passport),
                    style = MaterialTheme.typography.titleMedium,
                    textAlign = TextAlign.Start,
                    modifier = Modifier.padding(bottom = 5.dp)
                )
                OutlinedTextField(
                    value = idCardPassportInput,
                    onValueChange = {
                        idCardPassportInput = it
                    },
                    modifier = Modifier
                        .fillMaxWidth(),
                    singleLine = true,
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
                    value = phoneInput,
                    onValueChange = {
                        phoneInput = it
                    },
                    modifier = Modifier
                        .fillMaxWidth(),
                    singleLine = true,
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
                onClick = { navController.navigate(Route.CancellationPolicyScreen.route) },
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