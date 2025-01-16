package com.example.hotelapplication.ui.commonComponents.TextField

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hotelapplication.R
import com.example.hotelapplication.constant.EMPTY_STRING
import com.example.hotelapplication.ui.commonComponents.Texts.TextPlaceholder

@Composable
fun TextFieldCommon(
    value: String,
    onChangeValue: (value: String) -> Unit,
    label: String,
    leadingIcon: Int,
    trailingIcon: Int? = null,
    placeholder: String = EMPTY_STRING
) {
    var passwordVisible by rememberSaveable { mutableStateOf(trailingIcon == null) }

    TextField(
        value = value,
        onValueChange = {
            onChangeValue(it)
        },
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
        placeholder = {
            TextPlaceholder(text = placeholder)
        }
    )
}
@Preview(showBackground = true)
@Composable
fun TextFieldCommonPreview() {
    MaterialTheme {
        TextFieldCommon(
            "basc",
            { _ -> {}},
            label = "Enter location",
            leadingIcon = R.drawable.ic_location
        )
    }
}