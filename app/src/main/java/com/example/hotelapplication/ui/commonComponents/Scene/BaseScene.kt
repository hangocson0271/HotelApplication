package com.example.hotelapplication.ui.commonComponents.Scene

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.hotelapplication.R

@Composable
fun BaseScene(navController: NavController, titleScene: String, content: @Composable () -> Unit) {
    Scaffold(modifier = Modifier.fillMaxSize(), topBar = {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 50.dp),
            contentAlignment = Alignment.Center
        ) {
            // Back button, fixed to the left
            IconButton(
                onClick = { navController.navigateUp() },
                modifier = Modifier
                    .padding(start = 24.dp)
                    .width(
                        11.67.dp
                    )
                    .height(19.8.dp)
                    .align(Alignment.TopStart)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.arrows_navigation_arrow_left_back_icon), // Ensure you have the arrow icon
                    contentDescription = "Back"
                )
            }

            // Title centered in the top bar
            Text(
                text = titleScene, fontSize = 20.sp, color = colorResource(id = R.color.black),
                modifier = Modifier.align(Alignment.Center),
                fontWeight  = FontWeight.Bold,
                maxLines = 1
            )
        }
    }) {
        // Nội dung màn hình (nếu cần)
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            // Render the passed content
            content()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BaseScenePreview() {
    // Sử dụng NavController giả lập cho preview
    val navController = rememberNavController()
    BaseScene(navController = navController, titleScene = "Sample Title"){
        Text(text = "This is the dynamic content area.")
    }
}
