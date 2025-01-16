package com.example.hotelapplication.data.payment

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Payment(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "payment_id") var payment_id: Int = 0,
    @ColumnInfo(name = "booking_id") var booking_id: Int,
    @ColumnInfo(name = "method") var method: Int?,
    @ColumnInfo(name = "create_time") var create_time: Long?,
    @ColumnInfo(name = "pay_time") var pay_time: Long?,
    @ColumnInfo(name = "status") var status: Int?,
)


