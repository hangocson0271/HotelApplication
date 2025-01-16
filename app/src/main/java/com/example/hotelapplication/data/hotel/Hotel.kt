package com.example.hotelapplication.data.hotel

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Hotel(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "hotel_id") var hotel_id: Int = 0,
    @ColumnInfo(name = "hotel_name") var hotel_name: String,
    @ColumnInfo(name = "hotel_thumbnail") var hotel_thumbnail: String?,
    @ColumnInfo(name = "rate_star") var rate_star: Long?,
    @ColumnInfo(name = "total_rate") var total_rate: Int?,
    @ColumnInfo(name = "description") var description: String?,
    @ColumnInfo(name = "lat") var lat: Long?,
    @ColumnInfo(name = "lon") var lon: Long?,
    @ColumnInfo(name = "start_price") var start_price: Long?,
    @ColumnInfo(name = "wifi") var wifi: Int?,
    @ColumnInfo(name = "pool") var pool: Int?,
    @ColumnInfo(name = "breakfast") var breakfast: Int?,
    @ColumnInfo(name = "gym") var gym: Int?,
    @ColumnInfo(name = "bar") var bar: Int?,
    @ColumnInfo(name = "phone") var phone: String?,
    @ColumnInfo(name = "address") var address: String?,
)