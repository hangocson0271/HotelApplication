package com.example.hotelapplication.ui.features.forgotpassword

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hotelapplication.R
import com.example.hotelapplication.ui.theme.MainColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ForgotPasswordResultDialog(
    title: String,
    onDismiss: () -> Unit
) {

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
                Text(text = title)
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(0.dp, 16.dp, 0.dp, 0.dp),
                    horizontalArrangement = Arrangement.End
                ) {
                    ElevatedButton(
                        onClick = { onDismiss() },
                        colors = ButtonDefaults.elevatedButtonColors()
                            .copy(
                                containerColor = MainColor,
                                contentColor = colorResource(R.color.gray_e3e3e4)
                            )
                    ) {
                        Text(stringResource(R.string.txt_done))
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun ForgotPasswordResultPreview() {
    ForgotPasswordResultDialog(title = stringResource(R.string.txt_success)) { }
}