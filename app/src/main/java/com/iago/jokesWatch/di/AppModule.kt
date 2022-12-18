package com.iago.jokesWatch.di

import com.iago.jokesWatch.BuildConfig
import com.iago.jokesWatch.api.JokeApi
import com.iago.jokesWatch.repository.JokeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Singleton
    @Provides
    fun provideRepository(api: JokeApi) = JokeRepository(api)

    @Singleton
    @Provides
    fun provideApi(): JokeApi = Retrofit.Builder()
        .addConverterFactory((GsonConverterFactory.create()))
        .baseUrl(BuildConfig.API_BASE_URL)
        .build()
        .create(JokeApi::class.java)


}