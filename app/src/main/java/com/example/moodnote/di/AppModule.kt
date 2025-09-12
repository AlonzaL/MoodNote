package com.example.moodnote.di

import com.example.moodnote.data.MoodRepository
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

    fun provideMootRepository(): MoodRepository {
        return MoodRepository()
    }
}