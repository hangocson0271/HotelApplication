package com.example.hotelapplication.ui.features.main

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.navigation.NavController
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.hotelapplication.R
import com.example.hotelapplication.navigation.Route
import com.example.hotelapplication.ui.commonComponents.Buttons.ElevatedCardHomeScreen
import com.example.hotelapplication.ui.commonComponents.Buttons.ElevatedCardRoomScreen
import com.example.hotelapplication.ui.commonComponents.Images.UserAvatar
import com.example.hotelapplication.ui.commonComponents.SearchFilters.ButtonFilter
import com.example.hotelapplication.ui.commonComponents.SearchFilters.LayoutSearch
import com.example.hotelapplication.ui.commonComponents.Texts.HeaderLabelScreen

@Composable
fun RoomListScreen(
    modifier: Modifier = Modifier,
    navController: NavController
){
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
                ElevatedCardRoomScreen {}
            }
        }
    }
}