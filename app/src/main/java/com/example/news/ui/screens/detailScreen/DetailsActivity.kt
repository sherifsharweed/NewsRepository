package com.example.news.ui.screens.detailScreen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.news.ui.theme.NewsTheme

class DetailsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DetailContent()
                }
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun DetailContent() {
        Scaffold(topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = "Detaillsssss") },
                navigationIcon = {
                    IconButton(onClick = { finish() }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.Black
                        )
                    }
                }
            )
        }) { padding ->
            Box(Modifier.padding(padding)) {
                Column(
                    Modifier
                        .verticalScroll(rememberScrollState())
                        .padding(horizontal = 8.dp)
                ) {
                    Text(
                        "sdafssdafsadgfassdafssdafsadgfasdgsdafsadgfasdgsdafsadgfasdgsdafsadgfasdgsdafsadgfasdgadgfasdgsdafssdafsadgfasdgsdafsadgfasdgsdafsadgfasdgsdafsadgfasdgsdafsadgfasdgadgfasdgsdafssdafsadgfasdgsdafsadgfasdgsdafsadgfasdgsdafsadgfasdgsdafsadgfasdgadgfasdgdgsdafsadgfasdgsdafsadgfasdgsdafsadgfasdgsdafsadgfasdgadgfasdg",
                        fontSize = 50.sp
                    )
                    Text(
                        "sdafssdafsadgfasdgsdafssdafsadgfasdgsdafsadgfasdgsdafsadgfasdgsdafsadgfasdgsdafsadgfasdgadgfasdgsdafssdafsadgfasdgsdafsadgfasdgsdafsadgfasdgsdafsadgfasdgsdafsadgfasdgadgfasdgsdafssdafsadgfasdgsdafsadgfasdgsdafsadgfasdgsdafsadgfasdgsdafsadgfasdgadgfasdgsdafsadgfasdgsdafsadgfasdgsdafsadgfasdgsdafsadgfasdgadgfasdgsdafssdafsadgfasdgsdafsadgfasdgsdafsadgfasdgsdafsadgfasdgsdafsadgfasdgadgfasdgsdafssdafsadgfasdgsdafsadgfasdgsdafsadgfasdgsdafsadgfasdgsdafsadgfasdgadgfasdg",
                        fontSize = 50.sp
                    )
                    Text(
                        "sdgfsadsdafssdafsadgfasdgsdafsadgfasdgsdafsadgfasdgsdafsadgfasdgsdafsadgfasdgadgfasdgsdafssdafsadgfasdgsdafsadgfasdgsdafsadgfasdgsdafsadgfasdgsdafsadgfasdgadgfasdgsdafssdafsadgfasdgsdafsadgfasdgsdafsadgfasdgsdafsadgfasdgsdafsadgfasdgadgfasdgsdafssdafsadgfasdgsdafsadgfasdgsdafsadgfasdgsdafsadgfasdgsdafsadgfasdgadgfasdgg",
                        fontSize = 50.sp
                    )
                }
            }

        }

    }
}