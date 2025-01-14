package com.example.hotelapplication.ui.features.notifications.components

import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.hotelapplication.R

// Defined these notificatioTypes in Here
enum class NotificationType(val iconResId: Int, val subjectResId: Int, val contentResId: Int) {
    PasswordChange(
        iconResId = R.drawable.password_change,
        subjectResId = R.string.txt_subject_password_change,
        contentResId = R.string.txt_content_password_change
    ),

    OrderSuccess(
        iconResId = R.drawable.done_icon,
        subjectResId = R.string.txt_subject_order_placed_successfully,
        contentResId = R.string.txt_content_order_placed_successfully
    ),

    PaymentSuccess(
        iconResId = R.drawable.done_icon,
        subjectResId = R.string.txt_subject_payment_successfully,
        contentResId = R.string.txt_content_payment_successfully
    )
}
