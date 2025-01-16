package com.example.hotelapplication.ui.commonComponents.SearchFilters

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hotelapplication.R
import com.example.hotelapplication.extentions.hiltViewModel
import com.example.hotelapplication.ui.features.searchScreen.SearchViewModel


@Composable
fun SortDropDown(
    modifier: Modifier = Modifier,
    viewModel: SearchViewModel
) {
    val isDropDownExpanded = remember {
        mutableStateOf(false)
    }

    Column(
        modifier = modifier
            .wrapContentSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Box {
            Row(
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.clickable {
                    isDropDownExpanded.value = true
                }
            ) {
                Image(
                    modifier = Modifier.size(24.dp),
                    painter = painterResource(id = R.drawable.ic_sort),
                    contentDescription = "DropDown Icon"
                )
            }
            DropdownMenu(
                expanded = isDropDownExpanded.value,
                onDismissRequest = {
                    isDropDownExpanded.value = false
                }) {

                DropdownMenuItem(text = {
                    Text(
                        text = stringResource(R.string.all_title),
                    )
                }, onClick = {
                    isDropDownExpanded.value = false
                    viewModel.getAllHotels()
                })

                DropdownMenuItem(text = {
                    Text(
                        text = stringResource(R.string.price_increase_title),
                    )
                }, onClick = {
                    isDropDownExpanded.value = false
                    viewModel.getAllHotelWithPriceIncrease()
                })

                DropdownMenuItem(text = {
                    Text(
                        text = stringResource(R.string.price_decrease_title),
                    )
                }, onClick = {
                    isDropDownExpanded.value = false
                    viewModel.getAllHotelWithPriceDecrease()
                })

                DropdownMenuItem(text = {
                    Text(
                        text = stringResource(R.string.rate_increase_title),
                    )
                }, onClick = {
                    isDropDownExpanded.value = false
                    viewModel.getAllHotelWithRateIncrease()
                })

                DropdownMenuItem(text = {
                    Text(
                        text = stringResource(R.string.rate_decrease_title),
                    )
                }, onClick = {
                    isDropDownExpanded.value = false
                    viewModel.getAllHotelWithRateDecrease()
                })
            }
        }
    }
}

@Preview
@Composable
fun PreviewSortDropDown() {
    val viewModel = hiltViewModel<SearchViewModel>()
    SortDropDown(viewModel = viewModel)
}