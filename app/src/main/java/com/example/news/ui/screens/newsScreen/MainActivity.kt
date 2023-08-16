package com.example.news.ui.screens.newsScreen

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.news.ui.screens.detailScreen.DetailsActivity
import com.example.news.ui.screens.newsScreen.component.NewsScreen
import com.example.news.ui.theme.NewsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel by viewModels<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getAllNews()
        setContent {
            NewsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    NewsScreen(
                        newsState = viewModel.newsState,
                        event = viewModel::reducer
                    ) {
                        val intent = Intent(baseContext, DetailsActivity::class.java)
                        intent.putExtra("article", it)
                        startActivity(intent)
                    }
                }
            }
        }
    }
}