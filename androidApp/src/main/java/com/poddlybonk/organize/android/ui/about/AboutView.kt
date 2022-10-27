package com.poddlybonk.organize.android.ui.about

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun AboutView(
    onUpButtonClick: () -> Unit
) {
    Column {
        Toolbar(onUpButtonClick = onUpButtonClick)
        ContentView()
    }
}

@Composable
private fun Toolbar(onUpButtonClick: () -> Unit) {
    TopAppBar(
        title = { Text(text = "About Device") },
        navigationIcon = {
            IconButton(onClick = onUpButtonClick) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Up Button"
                )
            }
        }
    )
}

@Composable
private fun ContentView(){
}

@Preview(showBackground = true)
@Composable
private fun AboutPreview() {
    AboutView {
    }
}
