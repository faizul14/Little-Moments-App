package com.example.limoapp.ui.addmoment

import androidx.lifecycle.ViewModel
import com.example.limoapp.domain.model.DataModel
import com.example.limoapp.domain.usecase.UseCase

class AddMomentViewModel(private val useCase: UseCase) : ViewModel() {
    fun setSaveMoment(dataModel: DataModel) = useCase.saveMoment(dataModel)
}