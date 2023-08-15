package com.example.news.di

import com.example.news.data.remote.NewsRemoteDataSource
import com.example.news.data.remote.RemoteDataSource
import com.example.news.data.remote.network.NewsApiService
import com.example.news.data.repos.NewsRepo
import com.example.news.data.repos.NewsRepoImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DataSource {
    @Provides
    fun provideRemoteDataSource(
        newsApiService: NewsApiService,
    ): RemoteDataSource {
        return NewsRemoteDataSource(newsApiService)
    }

    @Provides
    fun provideNewsRepo(
        remoteDataSource: RemoteDataSource,
    ): NewsRepo {
        return NewsRepoImpl(remoteDataSource)
    }
}