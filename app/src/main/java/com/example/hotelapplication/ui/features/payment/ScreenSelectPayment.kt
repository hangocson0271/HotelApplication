package com.example.hotelapplication.ui.features.payment

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Text
import androidx.compose.material3.IconButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.hotelapplication.R
import com.example.hotelapplication.data.payment.Payment
import com.example.hotelapplication.extentions.hiltViewModel
import com.example.hotelapplication.ui.commonComponents.Buttons.PaymentButton
import com.example.hotelapplication.ui.commonComponents.Scene.BaseScene
import com.example.hotelapplication.ui.features.payment.components.PaymentMethodSelector
import com.example.hotelapplication.ui.features.payment.components.PaymentMethodViewModel

@Composable
fun SceneSelectPayment(navController: NavHostController, bookingId: Int, titleScene: String = "Payment") {
    val viewModel = hiltViewModel<PaymentMethodViewModel>()
    val selectedOption by viewModel.selectedOption.collectAsState()
    BaseScene(navController = navController, titleScene = titleScene) {
        Column(modifier = Modifier.fillMaxSize()) {
            TitleWithAction()
            Spacer(modifier = Modifier.height(30.dp))
            PaymentImage(selectedOption = selectedOption)
            Spacer(modifier = Modifier.height(30.dp))
            Text(
                text = stringResource(R.string.other_payment_method),
                fontSize = 16.sp,
                modifier = Modifier
                    .height(24.dp)
                    .padding(start = 23.dp),
                color = colorResource(id = R.color.black),
                fontWeight = FontWeight(600),
                maxLines = 1
            )
            Spacer(modifier = Modifier.height(30.dp))
            PaymentMethodSelector(modifier = Modifier.padding(start = 10.dp))
            Spacer(modifier = Modifier.height(50.dp))
            PaymentButton(
                modifier = Modifier.padding(start = 70.dp ),
                label = stringResource(id = R.string._continue),
                onClick = {
                    val payment = Payment(
                        booking_id = 123,
                        method = 1,
                        create_time = System.currentTimeMillis(),
                        pay_time = System.currentTimeMillis(),
                        status = 2
                    )
                    try {
                        Log.i("TAG", "Before insert in viewModel")
                        viewModel.insert(payment)
//                        Log.i("TAG", "Result: $result")
                    } catch (e: Exception) {
                        Log.e("TAG", "Error inserting payment: ${e.toString()}")
                        e.printStackTrace()
                    }
                })
        }
    }
}

@Composable
fun TitleWithAction() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp)
    ) {
        Text(
            text = stringResource(R.string.my_card),
            fontSize = 16.sp,
            modifier = Modifier
                .height(24.dp)
                .padding(start = 24.dp),
            color = colorResource(id = R.color.black),
            fontWeight = FontWeight(600),
            maxLines = 1
        )
        Spacer(modifier = Modifier.weight(1f))
        ClickableText(
            text = AnnotatedString(
                stringResource(R.string.edit_card),
                spanStyle = SpanStyle(
                    color = colorResource(id = R.color.main_color),
                    fontSize = 16.sp,
                    fontWeight = FontWeight(400)
                )
            ),
            onClick = {
                // navigate to edit card screen
            },
            modifier = Modifier.padding(0.dp, 0.dp, 24.dp, 0.dp)
        )
    }
}

@Composable
fun PaymentImage(selectedOption: Int) {
    val imageRes = when (selectedOption) {
        R.string.new_credit_debit_card -> R.drawable.debit_card
        R.string.paypal -> R.drawable.paypal_card
        R.string.google_pay -> R.drawable.google_pay_card
        else -> R.drawable.apple_pay_card
    }

    Image(
        painter = painterResource(id = imageRes),
        modifier = Modifier
            .padding(23.dp)
            .width(367.dp)
            .height(200.dp)
            .clip(RoundedCornerShape(20.dp)),
        contentScale = ContentScale.Crop,
        contentDescription = null
    )
}

@Preview(showBackground = true)
@Composable
fun SceneSelectPaymentPreview() {
    val navController = rememberNavController()
    SceneSelectPayment(navController = navController, bookingId = 0,  titleScene = "Payment")
}
