package com.example.hotelapplication.ui.features.payment.components

import android.annotation.SuppressLint
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
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
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.hotelapplication.R
import com.example.hotelapplication.ui.features.payment.components.PaymentMethodViewModel

@SuppressLint("ResourceAsColor")
@Composable
fun CardSelectMethod(
    @StringRes id: Int,
    icon: Painter,
    isSelected: Boolean,
    onSelect: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(46.dp)
            .background(
                color = Color(R.color.muted_Green_with_Transparency).copy(alpha = 0.15f),
                shape = RoundedCornerShape(12.dp)
            )
            .border(
                1.dp,
                color = colorResource(id = R.color.borderCard_color),
                shape = RoundedCornerShape(12.dp)
            ),
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
            modifier = Modifier.height(24.dp),
            fontWeight = FontWeight(500)
        )
        Spacer(modifier = Modifier.weight(1f))
        // RadioButton
        RadioButton(
            selected = isSelected,
            onClick = onSelect,
            colors = RadioButtonDefaults.colors(selectedColor = Color(0xFF00695C))
        )
    }
}

@Composable
fun PaymentMethodSelector(modifier: Modifier = Modifier) {
    val viewModel: PaymentMethodViewModel = viewModel()
    val selectedOption by viewModel.selectedOption.collectAsState()

    Column(modifier = modifier, verticalArrangement = Arrangement.spacedBy(20.dp)) {
        viewModel.paymentOptions.forEach { option ->
            CardSelectMethod(
                id = option.nameId,
                icon = painterResource(id = option.iconId),
                isSelected = option.nameId == selectedOption,
                onSelect = {
                    viewModel.selectPaymentMethod(option.nameId)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 23.dp) // Apply common modifier here
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CenteredPaymentSelectorPreview() {
    PaymentMethodSelector()
}
