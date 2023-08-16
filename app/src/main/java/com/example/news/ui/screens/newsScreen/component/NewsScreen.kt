package com.example.news.ui.screens.newsScreen.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.news.R
import com.example.news.data.remote.models.Articles
import com.example.news.ui.screens.newsScreen.state.NewsAction
import com.example.news.ui.screens.newsScreen.state.NewsState
import com.example.news.ui.screens.newsScreen.state.SearchState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsScreen(
    newsState: NewsState,
    searchBarState: SearchState,
    searchTextState: String,
    event: (NewsAction) -> Unit,
    onItemSelect: (Articles) -> Unit
) {
    Scaffold(topBar = {
        when (searchBarState) {
            SearchState.OPENED -> SearchAppBar(
                text = searchTextState,
                onTextChange = { event(NewsAction.WriteInSearchBar(it)) },
                onSearchClicked = { event(NewsAction.SearchForNews) }) {
                event(NewsAction.CloseSearchBar)
            }

            SearchState.CLOSED -> TopAppBar(
                title = { Text(text = stringResource(id = R.string.news)) },
                actions = {
                    IconButton(onClick = { event(NewsAction.OpenSearchBar) }) {
                        Icon(imageVector = Icons.Default.Search, contentDescription = "SearchIcon")
                    }
                }
            )
        }
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