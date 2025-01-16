package com.example.hotelapplication.ui.features.searchScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.hotelapplication.R
import com.example.hotelapplication.constant.EMPTY_STRING
import com.example.hotelapplication.extentions.hiltViewModel
import com.example.hotelapplication.navigation.Route
import com.example.hotelapplication.ui.commonComponents.Buttons.ElevatedCardHomeScreen
import com.example.hotelapplication.ui.commonComponents.SearchFilters.LayoutSearch
import com.example.hotelapplication.ui.commonComponents.SearchFilters.SortDropDown
import com.example.hotelapplication.ui.commonComponents.Texts.HeaderLabelScreen

@Composable
fun SearchScreen(
    navController: NavController
) {
    val viewModel = hiltViewModel<SearchViewModel>()
    val resultSearch = viewModel.hotelsResultSearch.collectAsState()
    var querySearch by remember { mutableStateOf("") }

    Column(
        Modifier.background(
            colorResource(
                R.color.white
            )
        )
    ) {
        HeaderLabelScreen(
            titleScreen = stringResource(R.string.search_screen_title),
            navController = navController,
        )
        Row(
            modifier = Modifier.padding(horizontal = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            LayoutSearch(isSearchable = true,
                percentFillWidth = 1f,
                contentSearch = querySearch,
                onQueryChanged = { newQuery -> querySearch = newQuery },
                onClick = {
                    viewModel.searchHotelWithName(querySearch)
                })
        }

        Text(
            modifier = Modifier.padding(10.dp), fontWeight = FontWeight.Bold, text = stringResource(
                R.string.hotel_result, resultSearch.value.size
            )
        )

        Box(
            modifier = Modifier
                .fillMaxWidth(),
        ) {
            SortDropDown(
                modifier = Modifier
                    .padding(end = 10.dp)
                    .align(Alignment.CenterEnd),
                viewModel
            )
        }
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
        ) {
            items(resultSearch.value.size) { index ->
                Spacer(
                    modifier = Modifier.padding(5.dp)
                )
                ElevatedCardHomeScreen(
                    hotelName = resultSearch.value[index].hotel_name,
                    rating = resultSearch.value[index].rate_star,
                    price = resultSearch.value[index].total_rate,
                    location = resultSearch.value[index].address ?: EMPTY_STRING,
                ) {
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
fun PreviewSearchScreen() {
    SearchScreen(navController = rememberNavController())
}