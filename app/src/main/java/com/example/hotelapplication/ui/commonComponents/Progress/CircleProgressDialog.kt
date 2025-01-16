package com.example.hotelapplication.ui.commonComponents.Progress

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hotelapplication.ui.theme.MainColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CircleProgressDialog() {
    BasicAlertDialog(
        onDismissRequest = {},
    ) {
        Card(
            colors = CardDefaults.cardColors().copy(containerColor = Color.Transparent)
        ) {
            Box(
                modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
            ) {
                CircularProgressIndicator(
                    modifier = Modifier.width(64.dp).height(64.dp),
                    color = MainColor,
                    trackColor = MaterialTheme.colorScheme.surfaceVariant,
                )
            }
        }
    }
}

@Preview
@Composable
fun CircularProgressDialogPreview() {
    CircleProgressDialog()
}