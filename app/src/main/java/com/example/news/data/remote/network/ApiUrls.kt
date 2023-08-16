package com.example.news.data.remote.network

const val API_KEY = "4c76e4a3c7f343b1943c04b1b1c8d462"

const val BASE_URL = "https://newsapi.org/v2/"
const val ALL_NEWS = "top-headlines?apiKey=$API_KEY&language=en"
const val SEARCHED = "everything?apiKey=$API_KEY&searchIn=title&sortBy=publishedAt"
const val SEARCH_QUERY = "q"
