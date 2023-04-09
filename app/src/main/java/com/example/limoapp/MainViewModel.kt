package com.example.limoapp

import androidx.lifecycle.ViewModel
import com.example.limoapp.domain.usecase.UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val useCase: UseCase) : ViewModel() {
    val dataAllMoment = useCase.getAllMoment()
}