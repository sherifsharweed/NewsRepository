package com.example.news.ui.screens.newsScreen.component

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.unit.dp

@Composable
fun ShimmerList() {
    ShimmerAnimation { brush ->
        LazyColumn {
            repeat(10) {
                item {
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .padding(all = 8.dp),
                    ) {
                        Spacer(
                            modifier = Modifier
                                .size(80.dp)
                                .background(brush = brush, RoundedCornerShape(50.dp))
                        )
                        Column(
                            Modifier.padding(start = 8.dp),
                            verticalArrangement = Arrangement.spacedBy(7.dp)
                        ) {
                            Spacer(
                                modifier = Modifier
                                    .width(100.dp)
                                    .height(30.dp)
                                    .background(brush = brush, RoundedCornerShape(5.dp))
                            )
                            Spacer(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(65.dp)
                                    .background(brush = brush, RoundedCornerShape(5.dp))
                            )
                            Row {
                                Spacer(
                                    modifier = Modifier
                                        .width(50.dp)
                                        .height(20.dp)
                                        .background(brush = brush, RoundedCornerShape(5.dp))
                                )
                                Spacer(modifier = Modifier.weight(1f))
                                Spacer(
                                    modifier = Modifier
                                        .width(50.dp)
                                        .height(20.dp)
                                        .background(brush = brush, RoundedCornerShape(5.dp))
                                )
                                Spacer(modifier = Modifier.height(5.dp))
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ShimmerAnimation(
    ShimmerItem: @Composable (Brush) -> Unit
) {
    val shimmerColorShades = listOf(
        Gray.copy(0.6f),
        Gray.copy(0.2f),
        Gray.copy(0.6f)
    )
    val transition = rememberInfiniteTransition()
    val translateAnim by transition.animateFloat(
        initialValue = 0f,
        targetValue = 1000f,
        animationSpec = infiniteRepeatable(
            tween(durationMillis = 1200, easing = FastOutSlowInEasing),
            RepeatMode.Restart
        )
    )
    val brush = Brush.linearGradient(
        colors = shimmerColorShades,
        start = Offset(10f, 10f),
        end = Offset(translateAnim, translateAnim)
    )
    ShimmerItem(brush)
}