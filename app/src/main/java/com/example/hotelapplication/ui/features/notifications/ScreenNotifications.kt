package com.example.hotelapplication.ui.features.notifications

import Notification
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.hotelapplication.R
import com.example.hotelapplication.ui.features.notifications.components.NotificationType
import com.example.hotelapplication.ui.features.notifications.components.NotificationsCard
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import com.example.hotelapplication.ui.commonComponents.Scene.BaseScene as BaseScene



@Composable
fun NotificationsScreen(navController: NavHostController,  notifications: List<Notification> = mutableListOf()) {
    val notifications = listOf(
        Notification(NotificationType.PasswordChange, LocalDate.of(2025, 1, 14)),
        Notification(NotificationType.PasswordChange, LocalDate.of(2025, 1, 14)),
        Notification(NotificationType.PasswordChange, LocalDate.of(2025, 1, 14)),
        Notification(NotificationType.PasswordChange, LocalDate.of(2025, 1, 14)),
        Notification(NotificationType.PasswordChange, LocalDate.of(2025, 1, 14)),
        Notification(NotificationType.PasswordChange, LocalDate.of(2025, 1, 14)),
        Notification(NotificationType.PasswordChange, LocalDate.of(2025, 1, 14)),
        Notification(NotificationType.PasswordChange, LocalDate.of(2025, 1, 14)),
        Notification(NotificationType.OrderSuccess, LocalDate.of(2025, 1, 14)),
        Notification(NotificationType.PaymentSuccess, LocalDate.of(2025, 1, 13)),
        Notification(NotificationType.PasswordChange, LocalDate.of(2025, 1, 12))
    )
    val groupedNotifications = notifications
        .groupBy { it.date }
        .toList()
        .sortedByDescending { it.first }
    val today = LocalDate.now()
    val yesterday = today.minusDays(1)
    BaseScene(
        navController = navController,
        titleScene = stringResource(id = R.string.txt_title_screen_notifications)
    )
    {
        LazyColumn(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
            groupedNotifications.forEach { (date, notificationsForDate) ->
                item {
                    Text(
                        text = when {
                            date == today -> "Today"
                            date == yesterday -> "Yesterday"
                            else -> date.format(DateTimeFormatter.ofPattern("dd MMMM yyyy"))
                        },

                        fontSize = 16.sp,
                        fontWeight = FontWeight(600),
                        modifier = Modifier.padding(10.dp)
                    )
                }

                notificationsForDate.forEach { notification ->
                    item {
                        NotificationsCard(notificationType = notification.notificationType)
                        Spacer(modifier = Modifier.height(10.dp))
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewNotificationsScreen() {
    val notifications = listOf(
        Notification(NotificationType.PasswordChange, LocalDate.of(2025, 1, 14)),
        Notification(NotificationType.PasswordChange, LocalDate.of(2025, 1, 14)),
        Notification(NotificationType.PasswordChange, LocalDate.of(2025, 1, 14)),
        Notification(NotificationType.PasswordChange, LocalDate.of(2025, 1, 14)),
        Notification(NotificationType.PasswordChange, LocalDate.of(2025, 1, 14)),
        Notification(NotificationType.PasswordChange, LocalDate.of(2025, 1, 14)),
        Notification(NotificationType.PasswordChange, LocalDate.of(2025, 1, 14)),
        Notification(NotificationType.PasswordChange, LocalDate.of(2025, 1, 14)),
        Notification(NotificationType.OrderSuccess, LocalDate.of(2025, 1, 14)),
        Notification(NotificationType.PaymentSuccess, LocalDate.of(2025, 1, 13)),
        Notification(NotificationType.PasswordChange, LocalDate.of(2025, 1, 12))
    )
    val navController = rememberNavController()
    NotificationsScreen(notifications = notifications, navController = navController)
}