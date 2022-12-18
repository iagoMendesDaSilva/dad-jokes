package com.iago.jokesWatch.api

import com.iago.jokesWatch.models.*
import retrofit2.http.*
import javax.inject.Singleton

@Singleton
interface JokeApi {

    @GET("dadjokes?limit=1")
    suspend fun getJokes(@Header("X-Api-Key") token: String): List<JokeModel>

}