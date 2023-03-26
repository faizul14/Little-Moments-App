package com.example.limoapp.data.local.room

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

abstract class MomentDatabase(): RoomDatabase() {
    abstract fun MomentDao(): MomentDao

    companion object{
        @Volatile
        private var INSTANCE: MomentDatabase? = null

        @JvmStatic
        fun getDatabase(context: Context): MomentDatabase =
            INSTANCE ?: synchronized(this){
                INSTANCE ?: Room.databaseBuilder(context.applicationContext,
                MomentDatabase::class.java, "moment_database").build()
            }
    }
}