package com.example.hotelapplication.data.room

import androidx.room.Dao
import androidx.room.Query
import com.example.hotelapplication.data.user.User
import kotlinx.coroutines.flow.Flow

@Dao
interface RoomDao {
    @Query("SELECT * FROM Room")
    fun getAll(): Flow<List<Room>>
    @Query("SELECT * FROM Room WHERE(hotel_id LIKE :hotelId)")
    fun getRoomByHotelId(hotelId :Int): Flow<List<Room>>
    @Query("SELECT * FROM Room WHERE room_Id = :roomId LIMIT 1")
    suspend fun getRoomById(roomId: Int): Room
}