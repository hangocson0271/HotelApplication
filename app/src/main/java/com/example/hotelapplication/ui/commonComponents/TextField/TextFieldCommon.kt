package com.example.hotelapplication.ui.commonComponents.TextField

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.hotelapplication.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldCommon(
    label: String,
    leadingIcon: Int,
    trailingIcon: Int? = null
) {
    var textInput by rememberSaveable { mutableStateOf("") }
    var passwordVisible by rememberSaveable { mutableStateOf(trailingIcon == null) }
    TextField(
        value = textInput,
        onValueChange = { textInput = it },
        label = {
            Text(text = label, color = colorResource(id = R.color.gray))
        },
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        leadingIcon = {
            Icon(
                painterResource(leadingIcon), contentDescription = null
            )
        },
        trailingIcon = {
            if (trailingIcon != null) {
                IconButton(
                    onClick = { passwordVisible = !passwordVisible }
                ) {
                    Icon(painterResource(trailingIcon), contentDescription = null)
                }
            }
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(PaddingValues(35.dp, 0.dp, 35.dp, 10.dp)),
        colors = TextFieldDefaults.colors(
            focusedContainerColor = colorResource(id = android.R.color.transparent),
            unfocusedContainerColor = colorResource(id = android.R.color.transparent),
            cursorColor = colorResource(id = R.color.main_color),
            focusedIndicatorColor = colorResource(id = R.color.main_color),
            unfocusedIndicatorColor = colorResource(id = R.color.gray)
        ),
    )
}