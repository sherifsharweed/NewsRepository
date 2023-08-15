package com.example.news.data.repos

import com.example.news.data.remote.models.Articles

interface NewsRepo {
    suspend fun getAllNews(): ArrayList<Articles>?
}