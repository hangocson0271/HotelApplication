package com.example.hotelapplication.ui.features.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.hotelapplication.R
import com.example.hotelapplication.navigation.Route
import com.example.hotelapplication.ui.commonComponents.Buttons.ElevatedCardRoomScreen
import com.example.hotelapplication.ui.commonComponents.Texts.HeaderLabelScreen

@Composable
fun RoomListScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    hotelId: Int,
) {
    val TAG = "RoomListScreen"
    Column(
        Modifier.background(
            colorResource(
                R.color.white
            )
        )
    ) {
        HeaderLabelScreen(
            titleScreen = (stringResource(R.string.room_list_screen)),
            navController = navController,
        )
        LazyColumn(
            modifier = Modifier
                .padding(5.dp)
                .background(
                    colorResource(
                        R.color.white
                    )
                )
        ) {
            items(10) {
                ElevatedCardRoomScreen {
                    navController.navigate(Route.BookingFormFirstPageScreen.route)
                }
            }
        }
    }
}