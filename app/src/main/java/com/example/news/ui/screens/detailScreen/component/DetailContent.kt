package com.example.news.ui.screens.detailScreen.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.news.R
import com.example.news.data.remote.models.Articles
import com.example.news.data.remote.models.Source
import com.example.news.ui.theme.buttonTitle
import com.example.news.ui.theme.date
import com.example.news.ui.theme.description
import com.example.news.ui.theme.mainTitle
import com.example.news.ui.utils.formatDate


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailContent(article: Articles?, onBackButton: () -> Unit, onWebsiteClick: (String?) -> Unit) {
    Scaffold(topBar = {
        TopAppBar(
            title = { Text(text = article?.title ?: "", maxLines = 1, style = mainTitle) },
            navigationIcon = {
                IconButton(onClick = onBackButton) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "Back",
                        tint = Color.Black
                    )
                }
            }
        )
    }) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxHeight()
                .verticalScroll(rememberScrollState())
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(article?.urlToImage).crossfade(true)
                    .build(),
                contentDescription = stringResource(R.string.new_image),
                contentScale = ContentScale.FillWidth,
                modifier = Modifier.fillMaxWidth()
            )
            Column(
                Modifier
                    .padding(horizontal = 8.dp)
            ) {
                Row(Modifier.padding(top = 8.dp)) {
                    Text(
                        formatDate(article?.publishedAt) ?: "", style = date
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Text(
                        article?.author ?: "", style = date
                    )
                }
                Text(
                    article?.description ?: "",
                    style = description,
                    modifier = Modifier.padding(top = 10.dp)
                )
                Text(
                    article?.content ?: "",
                    style = description,
                    modifier = Modifier.padding(top = 10.dp)
                )
                Row(Modifier.padding(top = 8.dp)) {
                    Text(
                        article?.source?.name ?: "", style = date
                    )
                }
            }
            Spacer(modifier = Modifier.weight(1f))
            Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
                Button(
                    onClick = { onWebsiteClick(article?.url) },
                    shape = RoundedCornerShape(20.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray),
                    modifier = Modifier.padding(vertical = 16.dp)
                ) {
                    Text(text = stringResource(id = R.string.go_to_website), style = buttonTitle)
                }
            }

        }
    }
}

@Preview
@Composable
fun Details() {
    DetailContent(
        article = Articles(
            source = Source(name = "sdfgsdfg"),
            author = "adsfasdfads",
            title = "rdfasdfasdf",
            description = "asdfasdfafdasdfadfafdasdfadsfadsfasfda",
            url = null,
            urlToImage = "https://variety.com/wp-content/uploads/2023/08/Screen-Shot-2023-08-15-at-8.54.38-AM.png?w=1000&h=563&crop=1",
            publishedAt = "2023-08-15T14:00:00Z",
            content = "asdfasdfadfasdfasdfasfdafsafafads"
        ), {}
    ) {

    }
}