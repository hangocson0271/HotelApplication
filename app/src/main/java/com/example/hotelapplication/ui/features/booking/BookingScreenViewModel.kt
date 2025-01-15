package com.example.hotelapplication.ui.features.booking

import android.nfc.Tag
import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import com.example.hotelapplication.base.BaseViewModel
import com.example.hotelapplication.data.booking.Booking
import com.example.hotelapplication.data.booking.BookingRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BookingScreenViewModel @Inject constructor(bookingRepository: BookingRepository) : BaseViewModel() {
    private val _bookings = MutableStateFlow<List<Booking>>(emptyList())
    val bookings: StateFlow<List<Booking>> = _bookings
    private val _insertedBookingId = mutableIntStateOf(-1)
    var insertedBookingId: State<Int> = _insertedBookingId

    private val bookingRes = bookingRepository

    init {
        getAllBookings()
    }

    private fun getAllBookings() {
        viewModelScope.launch {
            bookingRes.getAllBooking().collect { bookings ->
                _bookings.value = bookings
            }
        }
    }

    fun addNewBooking() {

        /* TODO implement to pass correct booking data for adding new booking */
        val userID = 1
        val roomID = 0
        val request = ""
        val checkIn = ""
        val checkOut = ""
        val totalPrice: Long = 124653
        val status = null
        val reservationId = ""


        val newBooking = Booking(userId = userID,
            roomId = roomID,
            request = request,
            checkInDate = checkIn,
            checkOutDate = checkOut,
            totalPrice = totalPrice,
            status = status,
            reservationId = reservationId)

        viewModelScope.launch {
            val newId = bookingRes.insertBooking(newBooking)
            Log.i("duongnbh", "return added bookingId $newId")
            _insertedBookingId.intValue = newId.toInt()
        }

    }

    fun resetInsertedBookingId() {
        _insertedBookingId.intValue = -1
    }
}