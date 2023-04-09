package com.example.limoapp.ui.addmoment

import androidx.lifecycle.ViewModel
import com.example.limoapp.domain.model.DataModel
import com.example.limoapp.domain.usecase.UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddMomentViewModel @Inject constructor(private val useCase: UseCase) : ViewModel() {
    fun setSaveMoment(dataModel: DataModel) = useCase.saveMoment(dataModel)
}