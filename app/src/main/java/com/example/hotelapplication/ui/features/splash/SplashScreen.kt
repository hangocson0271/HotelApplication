package com.example.hotelapplication.ui.features.splash

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.hotelapplication.R
import com.example.hotelapplication.navigation.Route
import com.example.hotelapplication.ui.features.splash.views.SplashText

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SplashScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Scaffold {
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(R.drawable.splash_bg),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier.matchParentSize()
            )
            Column (
                modifier = modifier.matchParentSize()
                    .background(color = colorResource(R.color.splash_blur)),
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Column(
                    modifier = modifier.padding(horizontal = 16.dp)
                ) {
                    SplashText(
                        stringResource(R.string.splash_screen_title),
                        fontSize = 36.sp
                    )
                    Spacer(modifier = Modifier.height(36.dp))
                    SplashText(
                        stringResource(R.string.splash_screen_description),
                        fontSize = 22.sp,
                        color = colorResource(R.color.splash_text_color)
                    )
                }

                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(modifier = Modifier.height(36.dp))
                    SplashText(
                        stringResource(R.string.splash_screen_subcontent),
                        fontSize = 18.sp,
                        color = colorResource(R.color.splash_text_color)
                    )
                    Spacer(modifier = Modifier.height(36.dp))
                    Button(
                        modifier = Modifier.defaultMinSize(150.dp, 50.dp),
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = colorResource(R.color.main_color)),
                        onClick = {
                        navController.navigate(Route.LoginScreen.route)
                    }
                    ) {
                        Text(
                            stringResource(R.string.btn_get_started),
                            fontSize = 18.sp
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    SplashScreen(navController = rememberNavController())
}