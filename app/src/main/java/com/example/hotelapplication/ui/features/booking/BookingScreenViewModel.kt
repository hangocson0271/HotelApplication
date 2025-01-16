package com.example.hotelapplication.ui.features.booking

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableIntStateOf
import androidx.lifecycle.viewModelScope
import com.example.hotelapplication.base.BaseViewModel
import com.example.hotelapplication.constant.SharePreferenceConstant
import com.example.hotelapplication.data.booking.Booking
import com.example.hotelapplication.data.booking.BookingRepository
import com.example.hotelapplication.data.room.RoomRepository
import com.example.hotelapplication.data.user.UserRepository
import com.example.hotelapplication.repositories.StoreValue
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BookingScreenViewModel @Inject constructor(
    private val bookingRepository: BookingRepository,
    private val userRepository: UserRepository,
    private val roomRepository: RoomRepository,
    private val storeValue: StoreValue
) : BaseViewModel() {
    private val _bookings = MutableStateFlow<List<Booking>>(emptyList())
    val bookings: StateFlow<List<Booking>> = _bookings
    private val _insertedBookingId = mutableIntStateOf(-1)
    var insertedBookingId: State<Int> = _insertedBookingId

    private val _checkInDate = MutableStateFlow<String>("")
    val checkInDate = _checkInDate.asStateFlow()

    private var _checkOutDate = MutableStateFlow<String>("")
    val checkOutDate = _checkOutDate.asStateFlow()

    private var _daysBetween= MutableStateFlow<Long>(0)
    val daysBetween = _daysBetween.asStateFlow()

    private var _notes= MutableStateFlow<String>("")
    var notes = _notes.asStateFlow()

    private var _userName = MutableStateFlow<String>("")
    val userName = _userName.asStateFlow()

    private var _phone = MutableStateFlow<String>("")
    val phone = _phone.asStateFlow()

    private var _email= MutableStateFlow<String>("")
    var email = _email.asStateFlow()

    private val currentUserId = storeValue.getIntValue(SharePreferenceConstant.USER_ID_PREF)

    private val bookingRes = bookingRepository
    private val userRes = userRepository
    private val roomRes = roomRepository

    init {
        getAllBookings()
        viewModelScope.launch {
            val currentUser = userRes.getUserById(currentUserId)
            _userName.value = currentUser?.user_name ?: "Nam"
            _phone.value = currentUser?.phone ?: "None"
            _email.value = currentUser?.email ?: "None"
            Log.i("TAG", "getUserById id: $currentUserId ${currentUser?.user_name}, ${currentUser?.email}, ${currentUser?.phone}")
        }
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
        val roomID = 0
        val totalPrice: Long = 124653
        val status = null
        val reservationId = ""

        val newBooking = Booking(
            userId = currentUserId,
            roomId = roomID,
            request = _notes.value,
            checkInDate = _checkInDate.value,
            checkOutDate = _checkOutDate.value,
            totalPrice = totalPrice,
            status = status,
            reservationId = reservationId
        )

        viewModelScope.launch {
            val newId = bookingRes.insertBooking(newBooking)
            Log.i("TAG", "return added bookingId $newId")
            _insertedBookingId.intValue = newId.toInt()
        }

    }

    fun resetInsertedBookingId() {
        _insertedBookingId.intValue = -1
    }

    fun setValues(checkIn: String, checkOut: String, days: Long) {
        storeValue.setStringValue(
            SharePreferenceConstant.CHECK_IN_PREF,
            checkIn
        )
        storeValue.setStringValue(
            SharePreferenceConstant.CHECK_OUT_PREF,
            checkOut
        )
        storeValue.setStringValue(
            SharePreferenceConstant.DAYS_BETWEEN_PREF,
            days.toString()
        )
    }

    fun getValues() {
        _checkInDate.value = storeValue.getStringValue(SharePreferenceConstant.CHECK_IN_PREF)
        _checkOutDate.value = storeValue.getStringValue(SharePreferenceConstant.CHECK_OUT_PREF)
        _daysBetween.value = storeValue.getStringValue(SharePreferenceConstant.DAYS_BETWEEN_PREF).toLong()
        _notes.value =
            storeValue.getStringValue(SharePreferenceConstant.NOTE_PREF).ifEmpty {
                "None"
            }
    }

    fun setNoteValue(notes: String) {
        storeValue.setStringValue(
            SharePreferenceConstant.NOTE_PREF,
            notes
        )
    }
}