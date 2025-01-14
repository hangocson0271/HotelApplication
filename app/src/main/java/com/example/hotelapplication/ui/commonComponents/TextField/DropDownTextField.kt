package com.example.hotelapplication.ui.commonComponents.TextField

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun DropDownTextField(dropDownList: List<String>, width: Dp = 150.dp){

    val mExpanded = remember { mutableStateOf(false) }
    val mSelectedText = remember { mutableStateOf("") }


    // Up Icon when expanded and down icon when collapsed
    val icon = if (mExpanded.value)
        Icons.Filled.KeyboardArrowUp
    else
        Icons.Filled.KeyboardArrowDown

    Column {

        // Create an Outlined Text Field
        // with icon and not expanded
        OutlinedTextField(
            value = mSelectedText.value,
            onValueChange = {},
            modifier = Modifier
                .width(width)
                ,
            readOnly = true,
            trailingIcon = {
                Icon(imageVector = icon, contentDescription = "contentDescription",
                    Modifier.clickable { mExpanded.value = !mExpanded.value })
            }
        )

        // Create a drop-down menu with list of cities,
        // when clicked, set the Text Field text as the city selected
        DropdownMenu (
            expanded = mExpanded.value,
            onDismissRequest = { mExpanded.value = false },
            modifier = Modifier
                .width(width)
        ) {
            dropDownList.forEach { dropItem ->
                DropdownMenuItem(
                    onClick = {
                        mSelectedText.value = dropItem
                        mExpanded.value = false
                    },
                    text = { Text(text = dropItem) },
                )
            }
        }
    }
}
