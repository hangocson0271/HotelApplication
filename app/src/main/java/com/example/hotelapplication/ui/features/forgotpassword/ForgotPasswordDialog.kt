package com.example.hotelapplication.ui.features.forgotpassword

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hotelapplication.R
import com.example.hotelapplication.constant.EMPTY_STRING
import com.example.hotelapplication.ui.theme.MainColor

@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun ForgotPasswordDialog(
    title: String,
    placeHolder: String,
    onDismiss: () -> Unit,
    onConfirm: (account: String) -> Unit,
    isError: Boolean? = false,
    errorMessage: Int? = 0,
) {
    var accountValue by rememberSaveable { mutableStateOf("") }


    BasicAlertDialog(
        onDismissRequest = onDismiss
    ) {
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(8.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 8.dp),
                    text = title
                )
                OutlinedTextField(
                    value = accountValue,
                    onValueChange = {
                        accountValue = it
                    }, placeholder = {
                        Text(placeHolder)
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
                    }
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(0.dp, 16.dp, 0.dp, 0.dp),
                    horizontalArrangement = Arrangement.End
                ) {
                    OutlinedButton(
                        onClick = { onDismiss() },
                        colors = ButtonDefaults.outlinedButtonColors().copy(
                            contentColor = MainColor
                        )
                    ) {
                        Text(stringResource(R.string.txt_cancel))
                    }
                    Spacer(
                        modifier =
                        Modifier.width(8.dp)
                    )
                    ElevatedButton(
                        onClick = { onConfirm(accountValue) },
                        colors = ButtonDefaults.elevatedButtonColors()
                            .copy(
                                containerColor = MainColor,
                                contentColor = colorResource(R.color.gray_e3e3e4)
                            )
                    ) {
                        Text(stringResource(R.string.txt_continue))
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun ForgotPasswordDialogPreview() {
    ForgotPasswordDialog(
        title = "Enter phone number / email:",
        placeHolder = "Phone/email",
        {},
        {})
}

@Preview
@Composable
fun ForgotPasswordStep2DialogPreview() {
    ForgotPasswordDialog(
        title = "Enter verification code:",
        placeHolder = "",
        {},
        {})
}