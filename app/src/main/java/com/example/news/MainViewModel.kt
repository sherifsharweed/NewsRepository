package com.example.news

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.news.data.repos.NewsRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val newsRepo: NewsRepo) : ViewModel() {

    fun getAll() {
        viewModelScope.launch {
            val res = newsRepo.getAllNews()
            Log.d("TAG", res.toString())
        }
    }


}