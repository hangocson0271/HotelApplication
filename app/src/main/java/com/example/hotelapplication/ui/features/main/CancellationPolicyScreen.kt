package com.example.hotelapplication.ui.features.main

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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hotelapplication.ui.theme.HotelApplicationTheme

@Composable
fun CancellationPolicyScreen() {

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
                text = "Cancellation Policy",
                style = TextStyle(fontSize = 28.sp, fontWeight = FontWeight.Bold),
                modifier = Modifier.fillMaxWidth(),
                color = Color(0xFF238C98),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(18.dp))

            Text(
                text = cancellationPolicyText(),
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
                        checkedColor = Color(0xFF238C98),
                        uncheckedColor = Color(0xFF238C98)
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
                    containerColor = Color(0xFF238C98)
                )
            ) {
                Text(text = "Cancel")
            }
            Button(
                onClick = { /* TODO: Handle button click*/ },
                modifier = Modifier
                    .padding(horizontal = 4.dp)
                    .width(150.dp),
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF238C98)
                ),
                enabled = isButtonEnabled
            ) {

                Text(text = "Accept")
            }
        }
    }
}

@Composable
fun cancellationPolicyText(): String {
    return """
        Thank you for choosing our service. We understand that sometimes plans change, and you may need to cancel or modify your booking. Below, you’ll find the details of our cancellation policy, which has been designed to be fair to both our customers and our business. Please read the following terms carefully before proceeding with any cancellations.

        1. Cancellation Period
        - You may cancel your booking or subscription up to 24 hours before the scheduled start time to receive a full refund.
        - Cancellations made within 24 hours of the scheduled start time will be subject to a cancellation fee of 50% of the total amount.
        - If the cancellation is made less than 2 hours before the scheduled time, no refund will be provided.
        - For subscription-based services, cancellations can be made at any time during the billing cycle. However, if you cancel your subscription mid-cycle, no pro-rated refund will be issued for the remaining period.

        2. How to Cancel
        To cancel your booking or subscription, please follow these steps:
        1. Log into your account on our website or mobile app.
        2. Navigate to the "My Bookings" or "My Subscriptions" section.
        3. Select the booking or subscription you wish to cancel.
        4. Click on the "Cancel" button and confirm your cancellation.

        Alternatively, you can contact our support team by email or phone, and they will assist you with the cancellation process.

        3. Refund Process
        - Refunds, if applicable, will be processed using the same payment method that was used for the original transaction. Please allow 5-7 business days for the refund to appear in your account, depending on your payment provider.
        - In case of a cancellation due to exceptional circumstances such as an emergency or illness, please contact our customer service team, and we may offer special consideration on a case-by-case basis.

        4. No-show Policy
        If you do not show up for your scheduled service and fail to cancel your booking within the specified time, you will not be entitled to a refund, and a no-show fee may apply. The no-show fee will be equivalent to the full cost of the service or booking.

        5. Exceptions to the Cancellation Policy
        While we have designed our cancellation policy to be fair and straightforward, we recognize that certain situations may warrant exceptions. The following are some cases where our standard cancellation policy may not apply:
        - Medical emergencies: If you are unable to attend due to a medical emergency, please provide relevant documentation, and we may offer a refund or reschedule at no extra cost.
        - Force Majeure: In cases of unforeseen events such as natural disasters, government-imposed restrictions, or other extraordinary circumstances beyond our control, we reserve the right to waive the cancellation fee or offer a full refund.

    """.trimIndent()
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HotelApplicationTheme {
        CancellationPolicyScreen()
    }
}
