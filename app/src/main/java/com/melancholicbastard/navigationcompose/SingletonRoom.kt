package com.melancholicbastard.navigationcompose

import android.graphics.Color


object SingletonRoom {
    val rooms = listOf(
        Room(0, "Комната с холодильником", Color.YELLOW, 100),
        Room(1, "Комната с диваном", Color.RED, 50),
        Room(2, "Комната с чипсиками", Color.YELLOW, 78),
        Room(3, "Комната с чайником", Color.YELLOW, 52)
        
    )
}