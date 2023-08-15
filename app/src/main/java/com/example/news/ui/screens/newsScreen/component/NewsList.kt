package com.example.news.ui.screens.newsScreen.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.news.R
import com.example.news.data.remote.models.Articles
import com.example.news.ui.theme.date
import com.example.news.ui.theme.description
import com.example.news.ui.theme.mainTitle

@Composable
fun NewsList(
    news: ArrayList<Articles>, onItemSelect: () -> Unit
) {
    LazyColumn {
        items(news.size) { index ->
            NewItem(news[index], onItemSelect)
            Divider(Modifier.padding(vertical = 10.dp))
        }
    }
}

@Composable
fun NewItem(
    articles: Articles, onItemSelect: () -> Unit
) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp)
            .clickable(onClick = onItemSelect),
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(articles.urlToImage)
                .crossfade(true)
                .build(),
            contentDescription = stringResource(R.string.new_image),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .clip(CircleShape)
                .size(80.dp)
        )
        Column(
            Modifier.padding(start = 8.dp),
            verticalArrangement = Arrangement.spacedBy(7.dp)
        ) {
            Text(text = articles.title ?: "", maxLines = 2, style = mainTitle)
            Text(text = articles.content ?: "", maxLines = 3, style = description)
            Text(
                text = articles.publishedAt ?: "",
                maxLines = 1,
                style = date,
                textAlign = TextAlign.Right
            )
        }
    }
}

