package com.example.betapp.di

import com.example.betapp.data.repository.MainRepositoryImpl
import com.example.betapp.domain.repository.MainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun provideMainRepository(): MainRepository {
        return MainRepositoryImpl()
    }
}