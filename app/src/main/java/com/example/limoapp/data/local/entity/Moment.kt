package com.example.limoapp.data.local.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
data class Moment (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0,

    @ColumnInfo(name = "comment")
    var comment: String? = null,

    @ColumnInfo(name = "path")
    var path: String? = null,

    @ColumnInfo(name = "time")
    var time: String? = null,

    @ColumnInfo(name = "emoji")
    var emoji: String? = null,
): Parcelable