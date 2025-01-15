package com.example.hotelapplication.data.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Room(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "room_id") var room_id: Int = 0,
    @ColumnInfo(name = "hotel_id") var hotel_id: Int,
    @ColumnInfo(name = "room_name") var room_name: String,
    @ColumnInfo(name = "room_thumbnail") var room_thumbnail: String?,
    @ColumnInfo(name = "description") var description: String?,
    @ColumnInfo(name = "room_type") var room_type: Int?,
    @ColumnInfo(name = "price") var price: Long?,
    @ColumnInfo(name = "is_available") var is_available: Int?,
    @ColumnInfo(name = "wifi") var wifi: Int?,
    @ColumnInfo(name = "pool") var pool: Int?,
    @ColumnInfo(name = "breakfast") var breakfast: Int?,
    @ColumnInfo(name = "gym") var gym: Int?,
    @ColumnInfo(name = "bar") var bar: Int?
)
