package com.example.news.data.remote

import com.example.news.data.remote.models.NewsApiResponse
import com.example.news.data.remote.network.NewsApiService
import java.io.IOException
import javax.inject.Inject

class NewsRemoteDataSource @Inject constructor(private val newsApiService: NewsApiService) :
    RemoteDataSource {
    override suspend fun getAllNews(): NewsApiResponse? {
        try {
            val response = newsApiService.getAllNews()
            return if (response.isSuccessful) response.body() else null
        } catch (e: IOException) {
            print(e.message)
        }
        return null
    }
}