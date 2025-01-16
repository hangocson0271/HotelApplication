package com.example.hotelapplication.ui.features.roomList

import androidx.lifecycle.viewModelScope
import com.example.hotelapplication.base.BaseViewModel
import com.example.hotelapplication.data.room.Room
import com.example.hotelapplication.data.room.RoomRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RoomListScreenViewModel @Inject constructor(roomRepository: RoomRepository) : BaseViewModel(){
    private val _rooms = MutableStateFlow<List<Room>>(emptyList())
    val rooms: StateFlow<List<Room>> = _rooms
    private val roomRes = roomRepository

    private fun getAllRooms() {
        viewModelScope.launch {
            roomRes.getAllRoom().collect { rooms ->
                _rooms.value = rooms
            }
        }
    }
    fun getRoomByHotelId(hotelId: Int){
        viewModelScope.launch {
            roomRes.getRoomByHotelId(hotelId).collect { rooms ->
                _rooms.value = rooms
            }
        }
    }
}