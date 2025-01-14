package com.example.hotelapplication.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.hotelapplication.ui.features.booking.BookingConfirmScreen
import com.example.hotelapplication.ui.features.booking.BookingFormFirstPageScreen
import com.example.hotelapplication.ui.features.login.LoginScreen
import com.example.hotelapplication.ui.features.booking.CancellationPolicyScreen
import com.example.hotelapplication.ui.features.editprofile.EditProfileScreen
import com.example.hotelapplication.ui.features.main.MainScreen
import com.example.hotelapplication.ui.features.main.RoomListScreen
import com.example.hotelapplication.ui.features.payment.SceneSelectPayment
import com.example.hotelapplication.ui.features.payment.components.PaymentMethodSelector
import com.example.hotelapplication.ui.features.searchScreen.SearchScreen
import com.example.hotelapplication.ui.features.signup.SignupScreen
import com.example.hotelapplication.ui.features.splash.SplashScreen

@Composable
fun HotelAppNavGraph() {
    val navController = rememberNavController()

    Scaffold() {
        NavHost(
            navController = navController,
            startDestination = Route.SplashScreen.route,
            modifier = Modifier.padding(it)
        ) {
            composable(Route.MainScreen.route) { MainScreen(navController = navController) }
            composable(Route.CancellationPolicyScreen.route) { CancellationPolicyScreen(navController) }
            composable(Route.SplashScreen.route) { SplashScreen(navController) }
            composable(Route.LoginScreen.route) { LoginScreen(navController) }
            composable(Route.SignupScreen.route) { SignupScreen(navController) }
            composable(Route.SceneSelectPayment.route) { SceneSelectPayment(navController) }
            composable(Route.BookingConfirmScreen.route) { BookingConfirmScreen(navController) }
            composable(Route.SearchScreen.route) { SearchScreen(navController) }
            composable(Route.BookingFormFirstPageScreen.route) { BookingFormFirstPageScreen(navController) }
            composable(Route.EditProfileScreen.route) {
                EditProfileScreen(navController= navController) }
            composable(Route.RoomListScreen.route) { RoomListScreen(navController= navController) }
        }
    }
}