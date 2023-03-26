package com.example.limoapp.data.local.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.limoapp.data.local.entity.MomentEntity

@Dao
interface MomentDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(moment: MomentEntity)

    @Update
    fun update(moment: MomentEntity)

    @Delete
    fun Delete(moment: MomentEntity)

    @Query("SELECT * from momententity ORDER BY id ASC")
    fun getAllMoment(): LiveData<List<MomentEntity>>
}