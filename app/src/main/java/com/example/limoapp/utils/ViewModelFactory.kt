package com.example.limoapp.utils

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.limoapp.MainViewModel
import com.example.limoapp.di.Injection
import com.example.limoapp.domain.usecase.UseCase
import com.example.limoapp.ui.addmoment.AddMomentViewModel

class ViewModelFactory private constructor(private val useCase: UseCase): ViewModelProvider.NewInstanceFactory(){

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(useCase) as T
        }
        if (modelClass.isAssignableFrom(AddMomentViewModel::class.java)) {
            return AddMomentViewModel(useCase) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }

    companion object{
        @Volatile
        private var INSTANCE: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory =
            INSTANCE ?: synchronized(this){
                INSTANCE ?: ViewModelFactory(Injection.provideUseCase(context))
            }
    }

}