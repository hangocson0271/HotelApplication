package com.example.hotelapplication.di


import android.app.Application
import android.content.Context
import com.example.hotelapplication.data.HotelBookingDatabase
import com.example.hotelapplication.data.payment.PaymentRepository
import com.example.hotelapplication.data.payment.PaymentRepositoryImpl
import com.example.hotelapplication.data.booking.BookingRepository
import com.example.hotelapplication.data.booking.BookingRepositoryImpl
import com.example.hotelapplication.data.hotel.HotelRepositoryImpl
import com.example.hotelapplication.data.hotel.HotelsRepository
import com.example.hotelapplication.data.room.RoomRepository
import com.example.hotelapplication.data.room.RoomRepositoryImpl
import com.example.hotelapplication.data.user.UserRepository
import com.example.hotelapplication.data.user.UserRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideHotelBookingDatabase(application: Application): HotelBookingDatabase {
        return HotelBookingDatabase.getDatabase(application)
    }

    @Provides
    @Singleton
    fun provideUserRepository(hotelBookingDatabase: HotelBookingDatabase): UserRepository {
        return UserRepositoryImpl(hotelBookingDatabase.userDao())
    }

    @Provides
    @Singleton
    fun providePaymentRepository(hotelBookingDatabase: HotelBookingDatabase): PaymentRepository {
        return PaymentRepositoryImpl(hotelBookingDatabase.paymentDao())
    }

    @Provides
    @Singleton
    fun provideHotelRepository(hotelBookingDatabase: HotelBookingDatabase): HotelsRepository {
        return HotelRepositoryImpl(hotelBookingDatabase.hotelDao())
    }

    @Provides
    @Singleton
    fun provideRoomRepository(hotelBookingDatabase: HotelBookingDatabase): RoomRepository {
        return RoomRepositoryImpl(hotelBookingDatabase.roomDao())

    }

    @Provides
    @Singleton
    fun provideBookingRepository(hotelBookingDatabase: HotelBookingDatabase): BookingRepository {
        return BookingRepositoryImpl(hotelBookingDatabase.bookingDao())
    }
    @Provides
    @Singleton
    fun provideContext(application: Application): Context {
        return application.applicationContext
    }
}