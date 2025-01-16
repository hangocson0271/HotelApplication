package com.example.hotelapplication.ui.features.roomList

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.hotelapplication.R
import com.example.hotelapplication.extentions.hiltViewModel
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
    val viewModel = hiltViewModel<RoomListScreenViewModel>()
    LaunchedEffect(Unit) {
        viewModel.getRoomByHotelId(hotelId)
    }
    val rooms = viewModel.rooms.collectAsState()
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
            if (rooms.value.isNotEmpty()){
                items(rooms.value.size) { index ->
                    ElevatedCardRoomScreen(
                        roomName = rooms.value[index].room_name,
                        roomType = rooms.value[index].room_type,
                        price = rooms.value[index].price,
                        isAvailable = rooms.value[index].is_available,
                        isHaveWifi = rooms.value[index].wifi,
                        isHavePool = rooms.value[index].pool,
                        isHaveBreakfast = rooms.value[index].breakfast,
                        isHaveGym = rooms.value[index].gym,
                        isHaveBar = rooms.value[index].bar,
                    ) {
                        navController.navigate(Route.BookingFormFirstPageScreen.route)
                    }
                }
            }
        }
    }
}