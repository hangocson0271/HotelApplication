package com.example.hotelapplication.data.hotel

import kotlinx.coroutines.flow.Flow

interface HotelsRepository {
    suspend fun getAllHotel(): Flow<List<Hotel>>
    suspend fun searchAllHotelsWithValue(name: String): Flow<List<Hotel>>

    suspend fun getAllHotelWithPriceIncrease(): Flow<List<Hotel>>
    suspend fun getAllHotelWithPriceDecrease(): Flow<List<Hotel>>
    suspend fun getAllHotelWithRateIncrease(): Flow<List<Hotel>>
    suspend fun getAllHotelWithRateDecrease(): Flow<List<Hotel>>
}

