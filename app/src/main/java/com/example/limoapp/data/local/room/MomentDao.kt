package com.example.limoapp.data.local.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.limoapp.data.local.entity.MomentEntity

@Dao
interface MomentDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(moment: MomentEntity)

    @Update
    fun update(moment: MomentEntity)

    @Delete
    fun Delete(moment: MomentEntity)

    @Query("SELECT * from momententity ORDER BY id DESC")
    fun getAllMoment(): LiveData<List<MomentEntity>>
}