package com.example.news.ui.screens.newsScreen.state

sealed interface NewsAction {
    object GetAllNews : NewsAction
    object OpenSearchBar : NewsAction
    object CloseSearchBar : NewsAction
    class WriteInSearchBar(val text: String) : NewsAction
    object SearchForNews : NewsAction
}