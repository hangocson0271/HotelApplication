package com.example.hotelapplication.di


import android.app.Application
import com.example.hotelapplication.data.HotelBookingDatabase
import com.example.hotelapplication.data.hotel.HotelRepositoryImpl
import com.example.hotelapplication.data.hotel.HotelsRepository
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
    fun provideHotelRepository(hotelBookingDatabase: HotelBookingDatabase): HotelsRepository {
        return HotelRepositoryImpl(hotelBookingDatabase.hotelDao())
    }
}