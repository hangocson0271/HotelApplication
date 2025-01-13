package com.example.hotelapplication.ui.features.main

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.hotelapplication.R
import com.example.hotelapplication.navigation.Route
import com.example.hotelapplication.ui.commonComponents.Buttons.ElevatedCardHomeScreen
import com.example.hotelapplication.ui.commonComponents.Images.UserAvatar
import com.example.hotelapplication.ui.commonComponents.SearchFilters.ButtonFilter
import com.example.hotelapplication.ui.commonComponents.SearchFilters.LayoutSearch

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    val TAG = "MainScreen"
    Column(
        Modifier.background(
            colorResource(
                R.color.white
            )
        )
    ) {
        Card(
            border = BorderStroke(0.5.dp, colorResource(R.color.main_color)),
            colors = CardDefaults.cardColors(containerColor = White),
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(),
        ) {
            Column {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    UserAvatar {
                        Log.d(TAG, "MainScreen: To Edit Profile")
                        navController.navigate(Route.EditProfileScreen.route)
                    }
                    Spacer(
                        modifier = Modifier.padding(5.dp)
                    )
                    Text(
                        textAlign = TextAlign.Center,
                        text = "Hello Nam",
                    )
                }
                Spacer(
                    modifier = Modifier.padding(5.dp)
                )
                Row(
                    modifier = Modifier.padding(horizontal = 10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    LayoutSearch(isSearchable = false,
                        percentFillWidth = 0.9f,
                        onClick = {
                            Log.d(TAG, "MainScreen: XXX")
                            navController.navigate(Route.SearchScreen.route)
                        })
                    ButtonFilter()
                }
                Spacer(
                    modifier = Modifier
                        .padding(5.dp)
                )
            }
        }

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .padding(5.dp)
        ) {
            items(100) { index ->
                Spacer(
                    modifier = Modifier.padding(5.dp)
                )
                ElevatedCardHomeScreen {
                    Log.d(TAG, "MainScreen: To Room list")
                    navController.navigate(Route.RoomListScreen.route)
                }
                Spacer(
                    modifier = Modifier.padding(5.dp)
                )
            }
        }
    }
}

@Preview
@Composable
fun Prev_Main() {
    MainScreen(navController = rememberNavController())
}