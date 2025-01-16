package com.example.hotelapplication.ui.commonComponents.Texts

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.hotelapplication.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HeaderLabelScreen(
    titleScreen: String,
    navController: NavController,
) {
    Surface(modifier = Modifier.fillMaxWidth()) {
        TopAppBar(modifier = Modifier.fillMaxWidth(), title = {
            Box(
                modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center
            ) {
                Text(text = titleScreen, style = MaterialTheme.typography.titleMedium)
            }
        }, navigationIcon = {
            IconButton(onClick = { navController.navigateUp() }) {
                Icon(
                    painter = painterResource(R.drawable.ic_previous),
                    contentDescription = "Back",
                    modifier = Modifier
                        .size(16.dp)
                )
            }
        }, actions = {
            // You can add action buttons here if needed
        })
    }
}


@Preview
@Composable
fun PreviewHeaderLabelScreen() {
    HeaderLabelScreen(
        navController = rememberNavController(), titleScreen = "Page Title"
    )
}