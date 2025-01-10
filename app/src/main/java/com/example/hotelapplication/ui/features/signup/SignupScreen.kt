package com.example.hotelapplication.ui.features.signup

import com.example.hotelapplication.R

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.hotelapplication.navigation.Route
import com.example.hotelapplication.ui.commonComponents.Buttons.LoginButton
import com.example.hotelapplication.ui.commonComponents.Buttons.OutLineImageButton
import com.example.hotelapplication.ui.commonComponents.TextField.TextFieldCommon
import com.example.hotelapplication.ui.commonComponents.Texts.TextLoginTitle

@Composable
fun SignupScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(35.dp, 0.dp, 0.dp, 0.dp),
            horizontalArrangement = Arrangement.Start,
        ) {
            TextLoginTitle(stringResource(R.string.sign_up))
        }

        Column {
            TextFieldCommon(stringResource(R.string.txt_username), R.drawable.message)
            TextFieldCommon(stringResource(R.string.txt_email), R.drawable.message)
            TextFieldCommon(stringResource(R.string.txt_password), R.drawable.lock, R.drawable.hide)
        }

        LoginButton(stringResource(R.string.sign_up)) {
            navController.navigate(Route.LoginScreen.route)
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(stringResource(R.string.txt_or))
            Spacer(modifier = Modifier.height(30.dp))
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                OutLineImageButton(
                    painterResource(R.drawable.img_google)
                ) { }
                Spacer(modifier = Modifier.width(30.dp))
                OutLineImageButton(
                    painterResource(R.drawable.img_apple)
                ) { }
            }
        }


        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(id = R.string.have_any_account),
                color = colorResource(id = R.color.black),
                fontSize = 12.sp,
                fontWeight = FontWeight(weight = 400),
            )
            ClickableText(
                text = AnnotatedString(
                    stringResource(id = R.string.sign_in),
                    spanStyle = SpanStyle(
                        fontSize = 14.sp,
                        color = colorResource(id = R.color.main_color),
                        fontWeight = FontWeight(weight = 600)
                    )
                ),
                onClick = {
                    navController.navigate(Route.LoginScreen.route) {
                        popUpTo(Route.SplashScreen.route)
                    }
                },
                modifier = Modifier.padding(16.dp, 0.dp, 0.dp, 0.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SignUpPreview() {
    SignupScreen(navController = rememberNavController())
}