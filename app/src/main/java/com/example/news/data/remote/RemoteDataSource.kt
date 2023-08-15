package com.example.news.data.remote

import com.example.news.data.remote.models.NewsApiResponse

interface RemoteDataSource {
    suspend fun getAllNews(): NewsApiResponse?
}