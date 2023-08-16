package com.example.news.data.repos

import com.example.news.data.remote.models.Articles

interface NewsRepo {
    suspend fun getAllNews(): ArrayList<Articles>?

    suspend fun getSearchedNews(text: String): ArrayList<Articles>?

}