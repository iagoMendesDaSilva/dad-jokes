package com.iago.jokesWatch.screens.home.commons


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.wear.compose.material.MaterialTheme
import androidx.wear.compose.material.Text
import com.iago.jokesWatch.models.JokeModel

@Composable
fun JokeItem(joke: JokeModel, onPress: () -> Unit) {
    Box(modifier = Modifier
        .fillMaxSize()
        .clickable {
            onPress()
        }, contentAlignment = Alignment.Center) {
        Text(
            text = joke.joke,
            color=MaterialTheme.colors.primary,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(.9f),
            maxLines = 5
        )
    }
}