package com.example.news.ui.screens.newsScreen.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.news.R
import com.example.news.ui.screens.newsScreen.state.NewsAction
import com.example.news.ui.screens.newsScreen.state.NewsState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsScreen(
    newsState: NewsState, event: (NewsAction) -> Unit, onItemSelect: () -> Unit
) {
    Scaffold(topBar = {
        CenterAlignedTopAppBar(
            title = { Text(text = stringResource(id = R.string.news)) },
        )
    }) { padding ->
        Box(
            modifier = Modifier.padding(padding),
        ) {
            if (newsState.loading) {
                //todo shimmer loading view
            } else if (newsState.isError) {
                //todo show error message
            } else {
                NewsList(
                    news = newsState.news, onItemSelect
                )
            }
        }
    }
}