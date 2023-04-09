package com.example.limoapp.di

import android.content.Context
import androidx.room.Room
import com.example.limoapp.data.local.room.MomentDao
import com.example.limoapp.data.local.room.MomentDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): MomentDatabase =
        Room.databaseBuilder(
            context,
            MomentDatabase::class.java,
            "moment_database"
        ).fallbackToDestructiveMigration().build()

    @Provides
    fun provideMomentDao(database: MomentDatabase): MomentDao = database.MomentDao()
}