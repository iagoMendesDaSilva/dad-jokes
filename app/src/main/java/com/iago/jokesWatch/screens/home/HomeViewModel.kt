package com.iago.jokesWatch.screens.home

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iago.jokesWatch.R
import com.iago.jokesWatch.models.JokeModel
import com.iago.jokesWatch.repository.JokeRepository
import com.iago.jokesWatch.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject
constructor(
    private val repository: JokeRepository,
) : ViewModel() {

    private val _jokes = MutableStateFlow<List<JokeModel>>(emptyList())
    val jokes = _jokes.asStateFlow()

    var loading = mutableStateOf(false)
    var error = mutableStateOf<Int?>(null)

    private fun startValuesToRequest() {
        loading.value = true
        error.value = null
    }

    fun getJokes() {
        viewModelScope.launch {
            startValuesToRequest()
            when (val response = repository.getJokes()) {
                is Resource.Success -> _jokes.value =response.data!!
                is Resource.Error -> error.value = R.string.error_default
            }
            loading.value = false
        }
    }


}