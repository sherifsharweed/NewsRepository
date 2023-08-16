package com.example.news.ui.utils

import android.annotation.SuppressLint
import java.text.SimpleDateFormat


@SuppressLint("SimpleDateFormat")
fun formatDate(articleDate: String?): String? {
    val parser = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
    val date = parser.parse(articleDate ?: "")
    val formatter = SimpleDateFormat("dd-MM-yyyy HH:mm")
    return formatter.format(date)
}