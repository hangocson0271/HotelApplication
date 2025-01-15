package com.example.hotelapplication.data.hotel

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface HotelDao {
    @Query("SELECT * FROM Hotel")
    fun getAll(): Flow<List<Hotel>>
}