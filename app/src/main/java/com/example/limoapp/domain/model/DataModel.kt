package com.example.limoapp.domain.model

import androidx.room.ColumnInfo

data class DataModel(
    val id: Int = 0,
    val comment: String? = null,
    val path: String? = null,
    val time: String? = null,
    val emoji: String? = null,
)
