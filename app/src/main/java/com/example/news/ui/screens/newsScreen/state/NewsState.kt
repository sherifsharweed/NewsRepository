package com.example.news.ui.screens.newsScreen.state

import com.example.news.data.remote.models.Articles

data class NewsState(
    val loading: Boolean = false,
    val isError: Boolean = false,
    val news: ArrayList<Articles> = arrayListOf()
)