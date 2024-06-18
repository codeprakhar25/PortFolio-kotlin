package com.example.portfolio.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun LazyColumnDemo() {
    LazyColmn()
}


@Composable
fun SimpleColumn() {
    val scrollstate = rememberScrollState()
    Column(modifier = Modifier.verticalScroll(scrollstate)) {
        for (i in 1..100){
            Text(text = "text $i", modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp), textAlign = TextAlign.Center)
    }
    }
}

@Composable
fun LazyColmn() {
    val scrollstate = rememberScrollState()
    LazyColumn(content = {
        items(count = 100 , itemContent = {
            Text(text = "text $it", modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp), textAlign = TextAlign.Center)
        })
    })
}