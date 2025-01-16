package com.example.hotelapplication.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.hotelapplication.ui.features.booking.BookingConfirmScreen
import com.example.hotelapplication.ui.features.booking.BookingFormFirstPageScreen
import com.example.hotelapplication.ui.features.booking.BookingFormSecondPageScreen
import com.example.hotelapplication.ui.features.booking.CancellationPolicyScreen
import com.example.hotelapplication.ui.features.editprofile.EditProfileScreen
import com.example.hotelapplication.ui.features.login.LoginScreen
import com.example.hotelapplication.ui.features.main.MainScreen
import com.example.hotelapplication.ui.features.roomList.RoomListScreen
import com.example.hotelapplication.ui.features.notifications.NotificationsScreen
import com.example.hotelapplication.ui.features.payment.SceneSelectPayment
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
//            startDestination = Route.MainScreen.route,
            modifier = Modifier.padding(it)
        ) {
            composable(Route.MainScreen.route) { MainScreen(navController = navController) }
            composable(Route.CancellationPolicyScreen.route) {
                CancellationPolicyScreen(
                    navController
                )
            }
            composable(Route.SplashScreen.route) { SplashScreen(navController) }
            composable(Route.LoginScreen.route) { LoginScreen(navController) }
            composable(Route.SignupScreen.route) { SignupScreen(navController) }
            composable(
                route = Route.SceneSelectPayment.route + "/{bookingId}",
                arguments = listOf(
                    navArgument("bookingId") {
                        type = NavType.IntType
                    }
                )
            ) { entry ->
                SceneSelectPayment(navController,
                    bookingId = entry.arguments?.getInt("bookingId") ?: 0)
            }
            composable(Route.BookingConfirmScreen.route) { BookingConfirmScreen(navController) }
            composable(Route.SearchScreen.route) { SearchScreen(navController) }
            composable(Route.NotificationsScreen.route) { NotificationsScreen(navController) }
            composable(
                route = Route.BookingFormFirstPageScreen.route + "/{roomId}",
                arguments = listOf(
                    navArgument("roomId") {
                        type = NavType.IntType
                    }
                )
            ) { entry ->
                BookingFormFirstPageScreen(
                    navController,
                    roomId = entry.arguments?.getInt("roomId") ?: 0
                )
            }
            composable(Route.BookingFormSecondPageScreen.route) {
                BookingFormSecondPageScreen(
                    navController
                )
            }
            composable(Route.EditProfileScreen.route) {
                EditProfileScreen(navController = navController)
            }

            composable(
                route = Route.RoomListScreen.route + "/{hotelId}",
                arguments = listOf(
                    navArgument("hotelId") {
                        type = NavType.IntType
                    }
                )
            ) { entry ->
                RoomListScreen(
                    navController = navController,
                    hotelId = entry.arguments?.getInt("hotelId") ?: 0
                )
            }
        }
    }
}