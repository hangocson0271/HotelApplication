package com.example.hotelapplication.ui.features.payment

import androidx.compose.foundation.background
import com.example.hotelapplication.ui.commonComponents.Scene.BaseScene
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.hotelapplication.R
import com.example.hotelapplication.navigation.Route
import com.example.hotelapplication.ui.commonComponents.Buttons.PaymentButton
import com.example.hotelapplication.ui.features.payment.components.PaymentMethodSelector

@Composable
fun SceneSelectPayment(navController: NavHostController, titleScene: String = "Payment") {
    BaseScene(navController = navController, titleScene = titleScene) {
        Column(modifier = Modifier.fillMaxSize()) {
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
                    fontWeight = FontWeight(
                        600
                    ),
                    maxLines = 1
                )
                Spacer(modifier = Modifier.weight(1f))
                ClickableText(
                    text = AnnotatedString(
                        stringResource(R.string.edit_card),
                        spanStyle = SpanStyle(
                            color = colorResource(id = R.color.main_color),
                            fontSize = 16.sp,
                            fontWeight = FontWeight(weight = 400)
                        )
                    ),
                    onClick = {
                        // navigate to edit card screen
                    },
                    modifier = Modifier.padding(0.dp, 0.dp, 24.dp, 0.dp)
                )
            }
            Spacer(modifier = Modifier.height(30.dp))
            Box(
                modifier = Modifier
                    .width(367.dp)
                    .height(200.dp)
                    .padding(start = 24.dp)
                    .background(color = colorResource(id = R.color.main_color))
            ) {

            }
            Spacer(modifier = Modifier.height(30.dp))
            Text(
                text = stringResource(R.string.other_payment_method),
                fontSize = 16.sp,
                modifier = Modifier
                    .height(24.dp)
                    .padding(start = 23.dp),
                color = colorResource(id = R.color.black),
                fontWeight = FontWeight(
                    600
                ),
                maxLines = 1
            )
            Spacer(modifier = Modifier.height(30.dp))
            PaymentMethodSelector(modifier = Modifier.padding(start = 40.dp))
            Spacer(modifier = Modifier.height(80.dp))
            PaymentButton(modifier = Modifier.padding(start = 70.dp) ,label = stringResource(id = R.string._continue), onClick = {
                //navigate to booking sumary screen
            })
        }

    }

}

@Preview(showBackground = true)
@Composable
fun SceneSelectPaymentPreview() {
    val navController = rememberNavController()
    SceneSelectPayment(navController = navController, titleScene = "Payment")
}
