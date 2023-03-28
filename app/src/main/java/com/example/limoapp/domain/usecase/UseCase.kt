package com.example.limoapp.domain.usecase

import androidx.lifecycle.LiveData
import com.example.limoapp.domain.model.DataModel

interface UseCase {
    fun getAllMoment(): LiveData<List<DataModel>>

    fun saveMoment(dataModel: DataModel)
}