import com.example.hotelapplication.ui.features.notifications.components.NotificationType
import java.time.LocalDate

data class Notification(
    val notificationType: NotificationType,
    val date: LocalDate // Ngày nhận thông báo
)