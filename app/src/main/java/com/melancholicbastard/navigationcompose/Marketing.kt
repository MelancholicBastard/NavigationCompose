package com.melancholicbastard.navigationcompose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun Marketing(
    id: Int = 0
) {
    val room = SingletonRoom.rooms.firstOrNull {it -> it.id == id}!!

    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(""+room.id)
        Text(room.name)
        Text(""+room.color)
        Text(""+room.size)
    }
}