package com.example.hotelapplication.data.hotel

import kotlinx.coroutines.flow.Flow

class HotelRepositoryImpl(private val hotelDao: HotelDao) : HotelsRepository {
    override suspend fun getAllHotel(): Flow<List<Hotel>> {
        return hotelDao.getAll()
    }

    override suspend fun searchAllHotelsWithValue(name: String): Flow<List<Hotel>> {
        return hotelDao.searchAllHotelsWithValue(name)
    }
}