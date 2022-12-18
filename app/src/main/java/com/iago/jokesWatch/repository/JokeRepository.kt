package com.iago.jokesWatch.repository

import com.iago.jokesWatch.BuildConfig
import com.iago.jokesWatch.R
import com.iago.jokesWatch.api.JokeApi
import com.iago.jokesWatch.models.JokeModel
import com.iago.jokesWatch.utils.Resource
import retrofit2.HttpException
import javax.inject.Inject

class JokeRepository @Inject constructor(private val api: JokeApi) {

    suspend fun getJokes(): Resource<List<JokeModel>> {
        val token = BuildConfig.API_KEY
        val response = try {
            api.getJokes(token)
        } catch (e: HttpException) {
            return Resource.Error(R.string.error_default)
        } catch (e: Exception) {
            return Resource.Error(R.string.error_default)
        }
        return Resource.Success(response)
    }
}