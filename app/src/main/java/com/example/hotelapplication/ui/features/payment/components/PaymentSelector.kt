package com.example.hotelapplication.ui.features.payment.components

import android.annotation.SuppressLint
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hotelapplication.R
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

@SuppressLint("ResourceAsColor")
@Composable
fun CardSelectMethod(
    @StringRes id: Int, icon: Painter, isSelected: Boolean,
    onSelect: () -> Unit
) {
    Row(
        modifier = Modifier
            .width(326.dp)
            .height(46.dp)
            .background(
                color = Color(R.color.muted_Green_with_Transparency).copy(alpha = 0.15f),
                shape = RoundedCornerShape(12.dp)
            )
            .border(1.dp, color = colorResource(id = R.color.borderCard_color), shape = RoundedCornerShape(12.dp)),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = icon,
            modifier = Modifier
                .width(30.dp)
                .height(24.dp),
            contentDescription = null,
            tint = Color.Unspecified
        )
        Spacer(modifier = Modifier.width(15.dp))
        Text(
            text = stringResource(id),
            fontSize = 16.sp,
            modifier = Modifier.height(
                24.dp
            ),
            fontWeight = FontWeight(500)
        )
        Spacer(modifier = Modifier.weight(1f))
        // RadioButton
        RadioButton(
            selected = isSelected,
            onClick = { onSelect() },
            colors = RadioButtonDefaults.colors(selectedColor = Color(0xFF00695C))
        )

    }
}


@Composable
fun PaymentMethodSelector(modifier: Modifier = Modifier) {
    // Danh sách các phương thức thanh toán
    val paymentOptions = listOf(
        Pair(R.string.new_credit_debit_card, R.drawable.debit_card_icon),
        Pair(R.string.paypal, R.drawable.paypal_icon),
        Pair(R.string.apple_pay, R.drawable.img_apple),
        Pair(R.string.google_pay, R.drawable.google_pay_logo_icon)
    )

    // Trạng thái được chọn
    var selectedOption by remember { mutableStateOf(paymentOptions[0].first) }

    Column (modifier = modifier , verticalArrangement = Arrangement.spacedBy(20.dp)){
        paymentOptions.forEach { option ->
            CardSelectMethod(
                id = option.first,
                icon = painterResource(id = option.second),
                isSelected = option.first == selectedOption,
                onSelect = { selectedOption = option.first }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CenteredPaymentSelectorPreview() {
    PaymentMethodSelector()
}
