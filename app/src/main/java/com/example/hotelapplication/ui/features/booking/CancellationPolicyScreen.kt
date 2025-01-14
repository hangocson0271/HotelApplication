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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.hotelapplication.R
import com.example.hotelapplication.ui.theme.HotelApplicationTheme
import com.example.hotelapplication.ui.theme.MainColor

@Composable
fun CancellationPolicyScreen(navController: NavController) {

    val scrollState = rememberScrollState()
    var isChecked by remember { mutableStateOf(false) }
    var isButtonEnabled by remember { mutableStateOf(false) }

    LaunchedEffect(isChecked) {
        isButtonEnabled = isChecked
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(6.dp)
    ) {

        Column(
            Modifier
                .fillMaxHeight(0.9f)
                .verticalScroll(scrollState)
                .padding(10.dp)
        ) {
            Text(
                text = stringResource(id = R.string.cancellation_policy_title),
                style = TextStyle(fontSize = 28.sp, fontWeight = FontWeight.Bold),
                modifier = Modifier.fillMaxWidth(),
                color = MainColor,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(18.dp))

            Text(
                text = stringResource(id = R.string.cancellation_policy_text).trimIndent(),
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(bottom = 1.dp),
                maxLines = Int.MAX_VALUE,
                overflow = TextOverflow.Visible
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Checkbox(
                    checked = isChecked,
                    onCheckedChange = {
                        isChecked = it
                    },
                    colors = CheckboxDefaults.colors(
                        checkedColor = MainColor,
                        uncheckedColor = MainColor
                    )
                )

                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "I accept the cancellation policy",
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }

        Spacer(modifier = Modifier.height(18.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                onClick = { /* TODO: Handle button click */ },
                modifier = Modifier
                    .padding(horizontal = 4.dp)
                    .width(150.dp),
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MainColor
                )
            ) {
                Text(text = stringResource(id = R.string.txt_cancel))
            }
            Button(
                onClick = { /* TODO: Handle button click*/ },
                modifier = Modifier
                    .padding(horizontal = 4.dp)
                    .width(150.dp),
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MainColor
                ),
                enabled = isButtonEnabled
            ) {

                Text(text = stringResource(id = R.string.txt_accept))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HotelApplicationTheme {
        CancellationPolicyScreen(navController = rememberNavController())
    }
}
