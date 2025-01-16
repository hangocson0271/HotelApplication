package com.example.hotelapplication.data.room

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface RoomDao {
    @Query("SELECT * FROM Room")
    fun getAll(): Flow<List<Room>>
    @Query("SELECT * FROM Room WHERE(hotel_id LIKE :hotelId)")
    fun getRoomByHotelId(hotelId :Int): Flow<List<Room>>
}