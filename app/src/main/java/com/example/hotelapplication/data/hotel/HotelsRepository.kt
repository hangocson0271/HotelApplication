package com.example.hotelapplication.data.hotel

import kotlinx.coroutines.flow.Flow

interface HotelsRepository {
    suspend fun getAllHotel(): Flow<List<Hotel>>
    suspend fun searchAllHotelsWithValue(name: String): Flow<List<Hotel>>
}

