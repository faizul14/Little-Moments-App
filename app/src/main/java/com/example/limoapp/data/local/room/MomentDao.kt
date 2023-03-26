package com.example.limoapp.data.local.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.limoapp.data.local.entity.Moment

@Dao
interface MomentDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(moment: Moment)

    @Update
    fun update(moment: Moment)

    @Delete
    fun Delete(moment: Moment)

    @Query("SELECT * from moment ORDER BY id ASC")
    fun getAllMoment(): LiveData<List<Moment>>
}