package com.example.limoapp.uidi

import com.example.limoapp.domain.usecase.ImplUseCase
import com.example.limoapp.domain.usecase.UseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class AppModule {
    @Binds
    @ViewModelScoped
    abstract fun provideUseCase(useCase: ImplUseCase): UseCase
}