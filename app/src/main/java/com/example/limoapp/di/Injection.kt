package com.example.limoapp.di

import android.content.Context
import com.example.limoapp.data.ImplRepository
import com.example.limoapp.data.local.room.MomentDatabase
import com.example.limoapp.domain.repository.Repository
import com.example.limoapp.domain.usecase.ImplUseCase
import com.example.limoapp.domain.usecase.UseCase
import com.example.limoapp.utils.AppExecutors

object Injection {
    private fun provideRepository(context: Context): Repository{
        val database = MomentDatabase.getDatabase(context)
        val appExecutors = AppExecutors()
        val dao = database.MomentDao()
        return ImplRepository.getInstance(appExecutors, dao)
    }

    fun provideUseCase(context: Context): UseCase{
        val repository = provideRepository(context)
        return ImplUseCase(repository)
    }
}