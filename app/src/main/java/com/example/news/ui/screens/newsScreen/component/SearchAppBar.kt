package com.example.news.ui.screens.newsScreen.component


import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.news.R
import com.example.news.ui.theme.mainTitle
import com.example.news.ui.utils.CLOSE_ICON
import com.example.news.ui.utils.SEARCH_ICON

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun SearchAppBar(
    text: String,
    onTextChange: (String) -> Unit,
    onSearchClicked: (String) -> Unit,
    onCloseSearch: () -> Unit
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
    ) {
        TextField(
            value = text,
            onValueChange = onTextChange,
            textStyle = mainTitle,
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                Text(
                    text = stringResource(id = R.string.search_hint),
                    color = Color.Gray,
                    modifier = Modifier.alpha(0.5f)
                )
            },
            singleLine = true,
            leadingIcon = {
                IconButton(onClick = {
                    onSearchClicked(text)
                    keyboardController?.hide()
                }, modifier = Modifier.alpha(0.5f)) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = SEARCH_ICON,
                        tint = Color.Black
                    )
                }
            },
            trailingIcon = {
                IconButton(onClick = {
                    onCloseSearch()
                    keyboardController?.hide()
                }, modifier = Modifier.alpha(0.5f)) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = CLOSE_ICON,
                        tint = Color.Black
                    )
                }
            },
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
            keyboardActions = KeyboardActions(onSearch = {
                onSearchClicked(text)
                keyboardController?.hide()
            }), colors =
            TextFieldDefaults.textFieldColors(
                cursorColor = Color.Black.copy(alpha = 0.5f),
                containerColor = Color.White,
                disabledTextColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            )
        )
    }
}

@Preview
@Composable
fun PreviewSearchApp() {
    SearchAppBar(text = "", onTextChange = {}, onSearchClicked = {}) {}
}