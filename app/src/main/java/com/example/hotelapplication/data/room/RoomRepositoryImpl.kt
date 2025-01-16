package com.example.hotelapplication.data.room

import kotlinx.coroutines.flow.Flow

class RoomRepositoryImpl(private val roomDao: RoomDao) : RoomRepository{
    override suspend fun getAllRoom(): Flow<List<Room>> {
        return roomDao.getAll()
    }

    override suspend fun getRoomByHotelId(hotelId : Int): Flow<List<Room>> {
        return roomDao.getRoomByHotelId(hotelId)
    }

    override suspend fun getRoomById(roomId: Int): Room {
        return roomDao.getRoomById(roomId)
    }
}