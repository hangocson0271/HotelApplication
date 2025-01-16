package com.example.hotelapplication.di

import com.example.hotelapplication.repositories.StoreValue
import com.example.hotelapplication.repositories.StoreValueImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoriesModule {
    @Binds
    @Singleton
    abstract fun bindStoreValue(store: StoreValueImpl) : StoreValue
}