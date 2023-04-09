package com.example.limoapp

import androidx.lifecycle.ViewModel
import com.example.limoapp.domain.usecase.UseCase

class MainViewModel(private val useCase: UseCase) : ViewModel() {
    val dataAllMoment = useCase.getAllMoment()
}