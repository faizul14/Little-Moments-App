package com.example.limoapp.domain.usecase

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.limoapp.domain.model.DataModel
import com.example.limoapp.domain.repository.Repository

class ImplUseCase(private val repository: Repository): UseCase {
    override fun getAllMoment(): LiveData<List<DataModel>> = repository.getAllMoment()
    override fun saveMoment(dataModel: DataModel) {
        repository.saveMoement(dataModel)
    }
}