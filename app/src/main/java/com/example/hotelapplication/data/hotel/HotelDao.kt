package com.example.hotelapplication.data.hotel

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface HotelDao {
    @Query("SELECT * FROM Hotel")
    fun getAll(): Flow<List<Hotel>>

    @Query(
        "SELECT * FROM Hotel" +
                " WHERE hotel_name LIKE '%' || :character || '%'" +
                " OR address LIKE '%' || :character || '%'"
    )
    fun searchAllHotelsWithValue(character: String): Flow<List<Hotel>>

    @Query("SELECT * FROM Hotel ORDER BY start_price ASC")
    fun getAllHotelWithPriceIncrease(): Flow<List<Hotel>>

    @Query("SELECT * FROM Hotel ORDER BY start_price DESC")
    fun getAllHotelWithPriceDecrease(): Flow<List<Hotel>>

    @Query("SELECT * FROM Hotel ORDER BY rate_star ASC")
    fun getAllHotelWithRateIncrease(): Flow<List<Hotel>>

    @Query("SELECT * FROM Hotel ORDER BY rate_star DESC")
    fun getAllHotelWithRateDecrease(): Flow<List<Hotel>>

}