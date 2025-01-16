package com.example.hotelapplication.data.hotel

import kotlinx.coroutines.flow.Flow

class HotelRepositoryImpl(private val hotelDao: HotelDao) : HotelsRepository {
    override suspend fun getAllHotel(): Flow<List<Hotel>> {
        return hotelDao.getAll()
    }

    override suspend fun searchAllHotelsWithValue(name: String): Flow<List<Hotel>> {
        return hotelDao.searchAllHotelsWithValue(name)
    }

    override suspend fun getAllHotelWithPriceIncrease(): Flow<List<Hotel>> {
        return hotelDao.getAllHotelWithPriceIncrease()
    }

    override suspend fun getAllHotelWithPriceDecrease(): Flow<List<Hotel>> {
        return hotelDao.getAllHotelWithPriceDecrease()
    }

    override suspend fun getAllHotelWithRateIncrease(): Flow<List<Hotel>> {
        return hotelDao.getAllHotelWithRateIncrease()
    }

    override suspend fun getAllHotelWithRateDecrease(): Flow<List<Hotel>> {
        return hotelDao.getAllHotelWithRateDecrease()
    }
}