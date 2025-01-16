package com.example.hotelapplication.data.paymentoption

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PaymentOption(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "option_id") var option_id: Int = 0,
    @ColumnInfo(name = "user_id") var user_id: Int,
    @ColumnInfo(name = "payment_type") var payment_type: Int?,
)
