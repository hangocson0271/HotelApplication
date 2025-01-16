package com.example.hotelapplication.ui.commonComponents.TextField

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.hotelapplication.R
import com.example.hotelapplication.constant.EMPTY_STRING
import com.example.hotelapplication.ui.theme.MainColor

@Composable
fun PasswordInputTextField(
    value: String,
    onValueChange: (value: String) -> Unit,
    placeholder: String,
    isError: Boolean? = false,
    errorMessage: Int? = 0,
) {
    var passwordVisibility by rememberSaveable { mutableStateOf(false) }

    OutlinedTextField(
        modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 16.dp),
        value = value,
        onValueChange = { onValueChange(it) },
        placeholder = {
            Text(placeholder)
        },
        colors = OutlinedTextFieldDefaults.colors().copy(
            cursorColor = MainColor,
            focusedIndicatorColor = MainColor,
        ),
        isError = isError ?: false,
        supportingText = {
            if (isError == true) {
                Text(errorMessage?.let { stringResource(it) } ?: EMPTY_STRING)
            }
        },
        visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = {
            IconButton(
                onClick = {
                    passwordVisibility = !passwordVisibility
                }
            ) {
                Icon(painterResource(R.drawable.hide), contentDescription = null)
            }
        },
    )
}