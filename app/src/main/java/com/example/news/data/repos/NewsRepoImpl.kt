package com.example.news.data.repos

import com.example.news.data.remote.RemoteDataSource
import com.example.news.data.remote.models.Articles
import javax.inject.Inject

class NewsRepoImpl @Inject constructor(private val remoteDataSource: RemoteDataSource) : NewsRepo {
    override suspend fun getAllNews(): ArrayList<Articles>? {
        return remoteDataSource.getAllNews()?.articles
    }

}