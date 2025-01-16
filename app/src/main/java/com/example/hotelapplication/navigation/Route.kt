package com.example.hotelapplication.navigation

sealed class Route(
    val route: String
) {
    object MainScreen : Route("MainScreenSample")
    object LoginScreen : Route("LoginScreen")
    object CancellationPolicyScreen : Route("CancellationPolicyScreen")
    object SignupScreen : Route("SignupScreen")
    object SceneSelectPayment : Route("SceneSelectPayment")
    object BookingConfirmScreen: Route("BookingConfirmScreen")
    object SearchScreen : Route("SearchScreen")
    object NotificationsScreen : Route("NotificationsScreen")
    object BookingFormFirstPageScreen : Route("BookingFormFirstPageScreen")
    object BookingFormSecondPageScreen : Route("BookingFormSecondPageScreen")
    object EditProfileScreen : Route("EditProfileScreen")
    object RoomListScreen : Route("RoomListScreen")
}