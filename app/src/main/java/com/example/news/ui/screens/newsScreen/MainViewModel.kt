package com.example.news.ui.screens.newsScreen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.news.data.repos.NewsRepo
import com.example.news.ui.screens.newsScreen.state.NewsAction
import com.example.news.ui.screens.newsScreen.state.NewsState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val newsRepo: NewsRepo) : ViewModel() {

    var newsState by mutableStateOf(NewsState())

    init {
        reducer(NewsAction.GetAllNews)
    }

    fun reducer(newsAction: NewsAction) {
        when (newsAction) {
            is NewsAction.GetAllNews -> getAllNews()
        }
    }

    fun getAllNews() {
        viewModelScope.launch {
            newsState = NewsState(loading = true)
            val res = newsRepo.getAllNews()
            res?.let {
                newsState = NewsState(news = it)
            }

        }
    }


}