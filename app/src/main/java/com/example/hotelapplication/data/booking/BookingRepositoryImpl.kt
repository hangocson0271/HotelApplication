package com.example.hotelapplication.data.booking

import com.example.hotelapplication.data.hotel.HotelDao
import kotlinx.coroutines.flow.Flow

class BookingRepositoryImpl(private val bookingDao: BookingDao): BookingRepository {
    override suspend fun getAllBooking(): Flow<List<Booking>> {
        return bookingDao.getAll()
    }

    override suspend fun insertBooking(booking: Booking): Long {
        return bookingDao.insert(booking)
    }

    override suspend fun deleteBooking(booking: Booking) {
        bookingDao.delete(booking)
    }

    override suspend fun updateBooking(booking: Booking) {
        bookingDao.update(booking)
    }
}