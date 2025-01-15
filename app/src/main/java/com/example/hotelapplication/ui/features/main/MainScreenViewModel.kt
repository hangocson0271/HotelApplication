package com.example.hotelapplication.ui.features.main

import androidx.lifecycle.viewModelScope
import com.example.hotelapplication.base.BaseViewModel
import com.example.hotelapplication.data.hotel.Hotel
import com.example.hotelapplication.data.hotel.HotelsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class MainScreenViewModel @Inject constructor(hotelRepository: HotelsRepository) : BaseViewModel() {

    private val hotelRes = hotelRepository

    private val _hotels = MutableStateFlow<List<Hotel>>(emptyList())
    val hotels: StateFlow<List<Hotel>> = _hotels

    init {
        getAllHotels()
    }

    private fun getAllHotels() {
        viewModelScope.launch {
            hotelRes.getAllHotel().collect { hotels ->
                _hotels.value = hotels
            }
        }
    }
}