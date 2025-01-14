package com.example.hotelapplication.navigation

sealed class Route(
    val route: String
) {
    object MainScreen : Route("MainScreenSample")
    object LoginScreen : Route("LoginScreen")
    object ForgotPasswordScreen : Route("LoginScreen")
    object CancellationPolicyScreen : Route("CancellationPolicyScreen")
    object SplashScreen : Route("SplashScreen")
    object SignupScreen : Route("SignupScreen")
    object SceneSelectPayment : Route("SceneSelectPayment")
    object BookingConfirmScreen: Route("BookingConfirmScreen")
    object SearchScreen : Route("SearchScreen")
    object BookingFormFirstPageScreen : Route("BookingFormFirstPageScreen")
    object BookingFormSecondPageScreen : Route("BookingFormSecondPageScreen")
    object EditProfileScreen : Route("EditProfileScreen")
    object RoomListScreen : Route("RoomListScreen")
}