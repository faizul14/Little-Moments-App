package com.example.limoapp.domain.usecase

import androidx.lifecycle.LiveData
import com.example.limoapp.domain.model.DataModel
import com.example.limoapp.domain.repository.Repository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ImplUseCase @Inject constructor(private val repository: Repository) : UseCase {
    override fun getAllMoment(): LiveData<List<DataModel>> = repository.getAllMoment()
    override fun saveMoment(dataModel: DataModel) {
        repository.saveMoement(dataModel)
    }
}