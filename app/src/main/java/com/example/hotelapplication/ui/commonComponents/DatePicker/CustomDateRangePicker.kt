package com.example.hotelapplication.ui.commonComponents.DatePicker

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Card
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.DateRangePicker
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SelectableDates
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.rememberDateRangePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hotelapplication.R
import com.example.hotelapplication.ui.theme.MainColor
import com.example.hotelapplication.ui.theme.SecondaryColor
import org.threeten.bp.Instant
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit
import java.util.Date
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomDateRangePicker(onValueChange: (String, String, Long) -> Unit) {

    val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")

    val todayOnwardDates: SelectableDates = object : SelectableDates {
        override fun isSelectableDate(utcTimeMillis: Long): Boolean {
            return utcTimeMillis >= System.currentTimeMillis()
        }

        override fun isSelectableYear(year: Int): Boolean {
            return year >= LocalDate.now().year
        }
    }
    val dateRangePickerState = rememberDateRangePickerState(selectableDates = todayOnwardDates)

    LaunchedEffect(dateRangePickerState.selectedStartDateMillis, dateRangePickerState.selectedEndDateMillis) {
        val startDate = longToDateString(dateRangePickerState.selectedStartDateMillis)
        val endDate = longToDateString(dateRangePickerState.selectedEndDateMillis)
        var daysBetween: Long = 0
        if(startDate.isNotEmpty() && endDate.isNotEmpty()) {
            val checkIn = LocalDate.parse(
                startDate,
                formatter
            )
            val checkOut = LocalDate.parse(
                endDate,
                formatter
            )
            daysBetween = ChronoUnit.DAYS.between(checkIn, checkOut)
        }
        onValueChange(startDate, endDate, daysBetween)
    }

    Column(modifier = Modifier.padding(start = 18.dp, end = 18.dp, top = 5.dp)) {
        Card {
            DateRangePicker(
                state = dateRangePickerState,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(410.dp),
                title = {
                    Text(
                        text = stringResource(id = R.string.select_date),
                        modifier = Modifier.padding(22.dp),
                        style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold)
                    )
                },
                headline = {},
                showModeToggle = false,
                colors = DatePickerDefaults.colors(
                    titleContentColor = Color.Black,
                    weekdayContentColor = Color.Red,
                    subheadContentColor = Color.Black,
                    dayInSelectionRangeContainerColor = SecondaryColor,
                    selectedDayContainerColor = MainColor
                )
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            horizontalArrangement = Arrangement.Absolute.SpaceBetween,
        ) {
            Text(
                text = stringResource(id = R.string.txt_check_in),
                style = MaterialTheme.typography.titleMedium,
                textAlign = TextAlign.Start
            )

            Text(
                text = stringResource(id = R.string.txt_check_out),
                style = MaterialTheme.typography.titleMedium,
                textAlign = TextAlign.End
            )
        }

        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween) {
            TextField(
                modifier = Modifier.width(150.dp),
                value = TextFieldValue(longToDateString(dateRangePickerState.selectedStartDateMillis)),
                onValueChange = {},
                readOnly = true,
                trailingIcon = { Icon(imageVector = Icons.Default.DateRange, contentDescription = "calendar") }
            )

            Icon(
                imageVector = Icons.Default.ArrowForward,
                contentDescription = "Arrow",
                modifier = Modifier.align(Alignment.CenterVertically)
            )

            TextField(
                modifier = Modifier.width(150.dp),
                value = TextFieldValue(longToDateString(dateRangePickerState.selectedEndDateMillis)),
                onValueChange = {},
                readOnly = true,
                trailingIcon = { Icon(imageVector = Icons.Default.DateRange, contentDescription = "calendar") }
            )
        }
    }
}


fun longToDateString(timestamp: Long?, format: String = "dd/MM/yyyy"): String {
    val sdf = SimpleDateFormat(format, Locale.getDefault())
    val date = timestamp?.let { Date(it) }
    return if (date != null) sdf.format(date) else ""
}