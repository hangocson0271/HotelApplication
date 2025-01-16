package com.example.hotelapplication.data.booking

import kotlinx.coroutines.flow.Flow

interface BookingRepository {
    suspend fun getAllBooking(): Flow<List<Booking>>

    suspend fun insertBooking(booking: Booking): Long

    suspend fun updateBooking(booking: Booking)

    suspend fun deleteBooking(booking: Booking)
}