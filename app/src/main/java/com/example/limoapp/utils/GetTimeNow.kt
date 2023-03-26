package com.example.limoapp.utils

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalTime
import java.time.format.DateTimeFormatter

object GetTimeNow {
    @RequiresApi(Build.VERSION_CODES.O)
    fun getCurrentTime(): String {
        val currentTime = LocalTime.now()
        val formatter = DateTimeFormatter.ofPattern("HH:mm")
        return currentTime.format(formatter)
    }
}