package com.example.limoapp.data.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.limoapp.data.local.entity.MomentEntity

@Database(entities = [MomentEntity::class], version = 1, exportSchema = false)
abstract class MomentDatabase : RoomDatabase() {
    abstract fun MomentDao(): MomentDao

//    companion object {
//        @Volatile
//        private var INSTANCE: MomentDatabase? = null
//
//        @JvmStatic
//        fun getDatabase(context: Context): MomentDatabase = INSTANCE ?: synchronized(this) {
//            INSTANCE ?: Room.databaseBuilder(
//                context.applicationContext, MomentDatabase::class.java, "moment_database"
//            ).build()
//        }
//    }
}