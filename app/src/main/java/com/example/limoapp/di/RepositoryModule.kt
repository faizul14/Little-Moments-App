package com.example.limoapp.di

import com.example.limoapp.data.ImplRepository
import com.example.limoapp.domain.repository.Repository
import com.example.limoapp.utils.AppExecutors
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module(includes = [DatabaseModule::class])
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule{
    @Singleton
    @Binds
    abstract fun provideRepository(repository: ImplRepository): Repository
}