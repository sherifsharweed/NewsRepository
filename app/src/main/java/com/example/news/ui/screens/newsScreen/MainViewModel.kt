package com.example.news.ui.screens.newsScreen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.news.data.repos.NewsRepo
import com.example.news.ui.screens.newsScreen.state.NewsAction
import com.example.news.ui.screens.newsScreen.state.NewsState
import com.example.news.ui.screens.newsScreen.state.SearchState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val newsRepo: NewsRepo) : ViewModel() {

    var newsState by mutableStateOf(NewsState())
    var searchState by mutableStateOf(SearchState.CLOSED)
    var searchTextState by mutableStateOf("")

    init {
        reducer(NewsAction.GetAllNews)
    }

    fun reducer(newsAction: NewsAction) {
        when (newsAction) {
            is NewsAction.GetAllNews -> getAllNews()
            is NewsAction.OpenSearchBar -> openSearchBar()
            is NewsAction.CloseSearchBar -> emptyOrCloseSearchBar()
            is NewsAction.WriteInSearchBar -> updateSearchText(newsAction.text)
            is NewsAction.SearchForNews -> onSearchNews(searchTextState)
        }
    }

    private fun getAllNews() {
        viewModelScope.launch {
            newsState = NewsState(loading = true)
            val res = newsRepo.getAllNews()
            res?.let {
                newsState = NewsState(news = it)
            }
        }
    }

    private fun openSearchBar() {
        searchState = SearchState.OPENED
    }

    private fun emptyOrCloseSearchBar() {
        if (searchTextState.isEmpty()) {
            searchState = SearchState.CLOSED
            getAllNews()
        } else {
            searchTextState = ""
        }
    }

    private fun updateSearchText(text: String) {
        searchTextState = text
    }

    private fun onSearchNews(text: String) {
        viewModelScope.launch {
            newsState = NewsState(loading = true)
            val res = if (text.isNotEmpty())
                newsRepo.getSearchedNews(text) else newsRepo.getAllNews()
            res?.let {
                newsState = NewsState(news = it)
            }
        }
    }


}