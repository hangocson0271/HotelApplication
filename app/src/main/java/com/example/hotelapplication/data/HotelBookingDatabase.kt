package com.example.hotelapplication.data

import android.content.Context
import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.hotelapplication.data.booking.Booking
import com.example.hotelapplication.data.booking.BookingDao
import com.example.hotelapplication.data.hotel.Hotel
import com.example.hotelapplication.data.hotel.HotelDao
import com.example.hotelapplication.data.payment.Payment
import com.example.hotelapplication.data.payment.PaymentDao
import com.example.hotelapplication.data.paymentoption.PaymentOption
import com.example.hotelapplication.data.paymentoption.PaymentOptionDao
import com.example.hotelapplication.data.room.Room
import com.example.hotelapplication.data.room.RoomDao
import com.example.hotelapplication.data.user.User
import com.example.hotelapplication.data.user.UserDao

@Database(
    entities = [User::class, Hotel::class, Room::class, Booking::class, Payment::class, PaymentOption::class],
    version = 1,
    exportSchema = false
)
abstract class HotelBookingDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun hotelDao(): HotelDao
    abstract fun roomDao(): RoomDao
    abstract fun bookingDao(): BookingDao
    abstract fun paymentDao(): PaymentDao
    abstract fun paymentOptionDao(): PaymentOptionDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: HotelBookingDatabase? = null

        fun getDatabase(context: Context): HotelBookingDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = androidx.room.Room.databaseBuilder(
                    context.applicationContext,
                    HotelBookingDatabase::class.java,
                    "hotel_database"
                )
                    .allowMainThreadQueries()
                    .createFromAsset("databases/hotelbooking.db")
                    .fallbackToDestructiveMigration()
                    .build()

                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}