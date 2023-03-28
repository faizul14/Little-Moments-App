package com.example.limoapp.domain.repository

import androidx.lifecycle.LiveData
import com.example.limoapp.domain.model.DataModel

interface Repository {
    fun getAllMoment(): LiveData<List<DataModel>>
    fun saveMoement(dataModel: DataModel)
}