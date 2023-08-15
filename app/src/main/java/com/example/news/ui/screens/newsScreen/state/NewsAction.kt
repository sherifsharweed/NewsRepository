package com.example.news.ui.screens.newsScreen.state

sealed interface NewsAction {
    object GetAllNews : NewsAction
}