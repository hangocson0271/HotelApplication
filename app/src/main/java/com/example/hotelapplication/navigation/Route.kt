package com.example.hotelapplication.navigation

sealed class Route (
    val route: String
    ){
    object MainScreenSample: Route("MainScreenSample")
    object LoginScreen: Route("LoginScreen")
    object ForgotPasswordScreen: Route("LoginScreen")
}