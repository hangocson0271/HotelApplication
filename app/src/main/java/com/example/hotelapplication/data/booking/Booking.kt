package com.example.hotelapplication.data.booking

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Booking(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "booking_id") var bookingId: Int = 0,
    @ColumnInfo(name = "user_id") var userId: Int,
    @ColumnInfo(name = "room_id") var roomId: Int,
    @ColumnInfo(name = "request") var request: String?,
    @ColumnInfo(name = "check_in_date") var checkInDate: String,
    @ColumnInfo(name = "check_out_date") var checkOutDate: String,
    @ColumnInfo(name = "total_price") var totalPrice: Long?,
    @ColumnInfo(name = "status") var status: Int?,
    @ColumnInfo(name = "reservation_id") var reservationId: String?,
)
