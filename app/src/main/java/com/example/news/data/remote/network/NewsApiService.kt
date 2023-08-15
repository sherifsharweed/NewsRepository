package com.example.news.data.remote.network

import com.example.news.data.remote.models.NewsApiResponse
import retrofit2.Response
import retrofit2.http.GET

interface NewsApiService {
    @GET(ALL_NEWS)
    suspend fun getAllNews(): Response<NewsApiResponse>
}