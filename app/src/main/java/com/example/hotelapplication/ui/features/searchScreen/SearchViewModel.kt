package com.example.hotelapplication.ui.features.searchScreen

import androidx.lifecycle.viewModelScope
import com.example.hotelapplication.base.BaseViewModel
import com.example.hotelapplication.data.hotel.Hotel
import com.example.hotelapplication.data.hotel.HotelsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@HiltViewModel
class SearchViewModel @Inject constructor(hotelRepository: HotelsRepository) : BaseViewModel() {

    private val hotelRes = hotelRepository

    private val _hotelsResultSearch = MutableStateFlow<List<Hotel>>(emptyList())
    val hotelsResultSearch: StateFlow<List<Hotel>> = _hotelsResultSearch

    init {
        getAllHotels()
    }

    private fun getAllHotels() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                delay(800)
            }
            hotelRes.getAllHotel().collect { hotels ->
                _hotelsResultSearch.value = hotels
            }
        }
    }

    fun searchHotelWithName(hotelName: String) {
        viewModelScope.launch {
            hotelRes.searchAllHotelsWithValue(hotelName).collect { hotels ->
                _hotelsResultSearch.value = hotels
            }
        }
    }
}