package com.example.limoapp.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.limoapp.data.local.room.MomentDao
import com.example.limoapp.domain.model.DataModel
import com.example.limoapp.domain.repository.Repository
import com.example.limoapp.utils.AppExecutors
import com.example.limoapp.utils.DataMapper
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ImplRepository @Inject constructor(
    private val appExecutors: AppExecutors,
    private val momentDao: MomentDao
) : Repository {
//    companion object {
//        @Volatile
//        private var INSTANCE: ImplRepository? = null
//
//        fun getInstance(
//            appExecutors: AppExecutors,
//            momentDao: MomentDao
//        ): ImplRepository = INSTANCE ?: synchronized(this) {
//            INSTANCE ?: ImplRepository(appExecutors, momentDao)
//        }.also { INSTANCE = it }
//    }

    override fun getAllMoment(): LiveData<List<DataModel>> {
        return Transformations.map(momentDao.getAllMoment()) {
            DataMapper.mapEntitiesToDomain(it)
        }
    }

    override fun saveMoement(dataModel: DataModel) {
        val dataMoment = DataMapper.mapDomainToEntity(dataModel)
        appExecutors.diskIO.execute {
            momentDao.insert(dataMoment)
        }
    }

}