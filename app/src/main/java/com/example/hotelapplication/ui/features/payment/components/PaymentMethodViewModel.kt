package com.example.hotelapplication.ui.features.payment.components

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hotelapplication.R
import com.example.hotelapplication.data.payment.Payment
import com.example.hotelapplication.data.payment.PaymentRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

// Data class to encapsulate payment method details
data class PaymentOption(
    val nameId: Int,
    val iconId: Int,
    val imageId: Int
)

@HiltViewModel
class PaymentMethodViewModel @Inject constructor(private val paymentRepository: PaymentRepository) :
    ViewModel() {

    // List of payment options using PaymentOption data class
    val paymentOptions = listOf(
        PaymentOption(
            R.string.new_credit_debit_card,
            R.drawable.debit_card_icon,
            R.drawable.debit_card
        ),
        PaymentOption(R.string.paypal, R.drawable.paypal_icon, R.drawable.paypal_card),
        PaymentOption(R.string.apple_pay, R.drawable.img_apple, R.drawable.apple_pay_card),
        PaymentOption(
            R.string.google_pay,
            R.drawable.google_pay_logo_icon,
            R.drawable.google_pay_card
        )
    )

    private val _selectedOption = MutableStateFlow(paymentOptions[0].nameId)
    val selectedOption: StateFlow<Int> = _selectedOption

    // Function to select a payment method
    fun selectPaymentMethod(optionId: Int) {
        _selectedOption.value = optionId
    }

    fun insert(payment: Payment) {
        viewModelScope.launch {
            Log.i("TAG", "Before insert in viewModelScope")
            val result = paymentRepository.insert(payment)
            Log.i("TAG", "After insert in viewModelScope $result")
        }
    }

    fun insertAll(payments: List<Payment>) {
        viewModelScope.launch { paymentRepository.insertAll(payments) }
    }
}
