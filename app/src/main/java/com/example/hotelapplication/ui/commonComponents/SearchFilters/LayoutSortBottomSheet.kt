package com.example.hotelapplication.ui.commonComponents.SearchFilters

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.SheetState
import androidx.compose.material3.SliderColors
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hotelapplication.R
import com.example.hotelapplication.ui.commonComponents.Buttons.CommonButton
import com.example.hotelapplication.ui.commonComponents.Buttons.CommonButtonsState
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SortAndFilterBottomSheet(
    isBottomSheetVisible: Boolean,
    sheetState: SheetState,
    onDismiss: () -> Unit
) {
    if (isBottomSheetVisible) {
        ModalBottomSheet(
            onDismissRequest = onDismiss,
            sheetState = sheetState,
            containerColor = Color.Transparent,
            contentColor = MaterialTheme.colorScheme.onSurface,
            shape = RectangleShape,
            dragHandle = null,
            scrimColor = Color.Black.copy(alpha = .5f),
            windowInsets = WindowInsets(0, 0, 0, 0)
        ) {
            val checkedStates = remember { List(5) { mutableStateOf(false) } }
            var sliderPosition by remember { mutableStateOf(100f..200f) }

            val colors = SliderDefaults.colors(
                activeTrackColor = colorResource(R.color.main_color),
                inactiveTrackColor = colorResource(R.color.disable_track),
                activeTickColor = MaterialTheme.colorScheme.primary, // Update to use the active track color
                inactiveTickColor = MaterialTheme.colorScheme.onSurface,
                thumbColor = colorResource(R.color.main_color),
                disabledActiveTrackColor = MaterialTheme.colorScheme.onSurface,
                disabledInactiveTrackColor = MaterialTheme.colorScheme.surface,
                disabledThumbColor = MaterialTheme.colorScheme.surface,
            )
            Column(
                modifier = Modifier
                    .navigationBarsPadding()
                    .padding(12.dp) // Outer padding
                    .clip(shape = RoundedCornerShape(24.dp))
                    .background(color = MaterialTheme.colorScheme.background)
                    .fillMaxWidth()
                    .padding(24.dp) // Inner padding
            ) {
                Box(
                    modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = stringResource(R.string.sort_filter_title),
                        style = MaterialTheme.typography.titleMedium
                    )
                }
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    HorizontalDivider(
                        color = Color.Gray,
                        thickness = 0.6.dp,
                        modifier = Modifier
                            .fillMaxWidth(0.9f)
                    )
                }

                Spacer(modifier = Modifier.height(12.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Text(
                        text = stringResource(R.string.sortBy_label),
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        color = colorResource(R.color.main_color),
                        text = stringResource(R.string.see_all_label),
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold

                    )
                }
                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    LazyVerticalGrid(
                        columns = GridCells.Fixed(3),
                    ) {
                        items(11) { item ->
                            ItemSort(
                                title = "Item No.$item",
                                isSelected = item % 2 == 0
                            )
                        }
                    }
                }

                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                )

                Text(
                    text = stringResource(R.string.sort_result_by_label),
                    fontWeight = FontWeight.Bold
                )
                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                )
                LazyRow {
                    items(5) { index ->
                        ItemSort(
                            title = "Item No.$index",
                            isSelected = index % 2 == 0
                        )
                        Spacer(
                            modifier = Modifier
                                .width(5.dp)
                        )
                    }
                }

                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                )

                RangeSlider(
                    modifier = Modifier.semantics {
                        contentDescription = "Localized Description"
                    },
                    value = sliderPosition,
                    onValueChange = { sliderPosition = it },
                    valueRange = 0f..500f,
                    colors = colors,
                    onValueChangeFinished = {
                        // launch some business logic update with the state you hold
                        // viewModel.updateSelectedSliderValue(sliderPosition)
                    },
                )

                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                )

                Text(
                    text = stringResource(R.string.star_rating_label),
                    fontWeight = FontWeight.Bold
                )
                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                )
                LazyRow {
                    items(5) { index ->
                        ItemSort(
                            title = "$index",
                            isSelected = index == 0,
                            image = painterResource(R.drawable.ic_star)
                        )
                        Spacer(
                            modifier = Modifier
                                .width(5.dp)
                        )
                    }
                }

                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                )

                Text(
                    text = stringResource(R.string.facilities_label),
                    fontWeight = FontWeight.Bold
                )
                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                )
                LazyRow {
                    items(5) { item ->
                        Row(
                            horizontalArrangement = Arrangement.Start,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Checkbox(
                                checked = checkedStates[item].value,
                                onCheckedChange = { isChecked ->
                                    checkedStates[item].value = isChecked
                                },
                                colors = CheckboxDefaults.colors()
                                    .copy(
                                        checkedBoxColor = colorResource(R.color.main_color),
                                        checkedBorderColor = colorResource(R.color.main_color)
                                    )
                            )
                            Text(
                                text = stringResource(R.string.wifi_label),
                                color = colorResource(R.color.dark_gray)
                            )
                        }
                    }
                }

                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                )
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    HorizontalDivider(
                        color = Color.Gray,
                        thickness = 0.6.dp,
                        modifier = Modifier
                            .fillMaxWidth(0.9f)
                    )
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                ) {
                    CommonButton(
                        title = stringResource(R.string.reset_label),
                        buttonType = CommonButtonsState.TYPE_2,
                        onClick = {},
                        modifier = Modifier.weight(1f)
                    )

                    Spacer(modifier = Modifier.width(5.dp))
                    CommonButton(
                        title = stringResource(R.string.apply_label),
                        buttonType = CommonButtonsState.TYPE_1,
                        onClick = {},
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun PreviewSortAndFilterBottomSheet() {
    val sheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = true
    )
    val scope = rememberCoroutineScope()
    var isBottomSheetVisible by rememberSaveable { mutableStateOf(false) }

    scope.launch {
        isBottomSheetVisible = true
        sheetState.expand()
    }
    SortAndFilterBottomSheet(
        isBottomSheetVisible = isBottomSheetVisible,
        sheetState = sheetState,
        onDismiss = {
            scope.launch { sheetState.hide() }
                .invokeOnCompletion { isBottomSheetVisible = false }
        }
    )
}