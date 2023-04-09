package com.example.limoapp.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MomentEntity (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") var id: Int,

    @ColumnInfo(name = "comment") var comment: String,

    @ColumnInfo(name = "path") var path: String,

    @ColumnInfo(name = "time") var time: String,

    @ColumnInfo(name = "emoji") var emoji: String,
)