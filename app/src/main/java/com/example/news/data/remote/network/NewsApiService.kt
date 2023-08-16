package com.example.news.data.remote.network

import com.example.news.data.remote.models.NewsApiResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {
    @GET(ALL_NEWS)
    suspend fun getAllNews(): Response<NewsApiResponse>

    @GET(SEARCHED)
    suspend fun getSearchedNews(@Query(SEARCH_QUERY) searchedText: String): Response<NewsApiResponse>
}