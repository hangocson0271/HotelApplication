package com.example.hotelapplication.data.room

import kotlinx.coroutines.flow.Flow

interface RoomRepository {
    suspend fun getAllRoom(): Flow<List<Room>>
    suspend fun getRoomByHotelId(hotelId :Int): Flow<List<Room>>
}