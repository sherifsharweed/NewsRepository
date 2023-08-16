package com.example.news.ui.screens.detailScreen

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.news.data.remote.models.Articles
import com.example.news.ui.screens.detailScreen.component.DetailContent
import com.example.news.ui.theme.NewsTheme

class DetailsActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val article = intent.getSerializableExtra("article", Articles::class.java)
        setContent {
            NewsTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DetailContent(article, { finish() }) {
                        if (!it.isNullOrEmpty()) {
                            val openURL = Intent(Intent.ACTION_VIEW)
                            openURL.data = Uri.parse(it)
                            startActivity(openURL)
                        }
                    }
                }
            }
        }
    }
}
