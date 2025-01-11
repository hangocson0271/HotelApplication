package com.example.hotelapplication.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import com.example.hotelapplication.ui.features.main.CancellationPolicyScreen
import com.example.hotelapplication.ui.features.main.MainScreen

@Composable
fun HotelAppNavGraph() {
    val navController = rememberNavController()

    Scaffold(modifier = Modifier.padding(top = 48.dp)) {
        NavHost(
            navController = navController,
            startDestination = Route.MainScreenSample.route,
            modifier = Modifier.padding(it)
        ) {
            composable(Route.MainScreenSample.route) { MainScreen() }

            composable(Route.CancellationPolicyScreen.route) { CancellationPolicyScreen() }
        }
    }
}