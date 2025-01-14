package com.example.hotelapplication.ui.commonComponents.TextField

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.hotelapplication.R

@Composable
fun NumericTextField(width: Dp = 150.dp) {

    var textInput by rememberSaveable { mutableStateOf("1") }

    OutlinedTextField(
        value = textInput,
        onValueChange = {
            if (it.all { char -> (char.isDigit() && char.toString().toInt() > 0)  })
                textInput = it
        },
        modifier = Modifier
            .width(width),
        singleLine = true,
        textStyle = TextStyle(textAlign = TextAlign.Center),
        leadingIcon = {
            Icon(
                painterResource(R.drawable.ic_remove),
                contentDescription = "minus",
                modifier = Modifier.clickable {
                    if(textInput.toInt() > 1) textInput = textInput.toInt().dec().toString()
                }
            )
        },
        trailingIcon = {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "plus",
                modifier = Modifier.clickable {
                    textInput = textInput.toInt().inc().toString()
                })
        }
    )
}