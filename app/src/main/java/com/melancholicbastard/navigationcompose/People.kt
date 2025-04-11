package com.melancholicbastard.navigationcompose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun People(
    padding: PaddingValues,
    id: Int = 0
) {
    val human = SingletonPeople.humans.firstOrNull {it -> it.id == id}!!

    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
            .padding(padding)
    ) {
        Text(""+human.id)
        Text(human.humanName)
        Text(""+human.humanJob)
    }
}