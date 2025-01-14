package com.example.hotelapplication.data.booking

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Booking(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "booking_id") var booking_id: Int = 0,
    @ColumnInfo(name = "user_id") var user_id: Int,
    @ColumnInfo(name = "room_id") var room_id: Int,
    @ColumnInfo(name = "request") var request: String?,
    @ColumnInfo(name = "check_in_date") var check_in_date: String,
    @ColumnInfo(name = "check_out_date") var check_out_date: String,
    @ColumnInfo(name = "total_price") var total_price: Long?,
    @ColumnInfo(name = "status") var status: Int?,
    @ColumnInfo(name = "reservation_id") var reservation_id: String?,
)
