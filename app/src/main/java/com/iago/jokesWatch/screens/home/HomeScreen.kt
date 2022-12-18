package com.iago.jokesWatch.screens.home

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.wear.compose.material.*
import com.iago.jokesWatch.screens.home.commons.JokeItem
import com.iago.jokesWatch.screens.home.commons.Load
import com.iago.jokesWatch.screens.home.commons.Refresh

@Composable
fun HomeScreen() {

    val context = LocalContext.current
    val homeViewModel = hiltViewModel<HomeViewModel>()

    val jokes = homeViewModel.jokes.collectAsState().value

    LaunchedEffect(key1 = true, block = {
        homeViewModel.getJokes()
    })

    if (homeViewModel.error.value != null)
        Toast.makeText(
            context,
            stringResource(id = homeViewModel.error.value!!),
            Toast.LENGTH_SHORT
        )
            .show()

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.background),
        timeText = { TimeText() },
        vignette = { VignettePosition.TopAndBottom },
    ) {
        if (homeViewModel.error.value != null)
            Refresh() { homeViewModel.getJokes() }
        else if (homeViewModel.loading.value)
            Load()
        else if (jokes.isNotEmpty())
            JokeItem(jokes[0]) {
                homeViewModel.getJokes()
            }
    }
}


