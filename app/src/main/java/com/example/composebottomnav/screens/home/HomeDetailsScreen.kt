package com.example.composebottomnav.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showSystemUi = true, showBackground = true)
@Composable
fun HomeDetailScreen(
    onNavigateToOverView: () -> Unit = {}
){
    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier.shadow(elevation = 3.dp),
                title = { Text("Home Details") },
            )
        }
    ) { paddingValues ->
        Column(
            Modifier.padding(paddingValues)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextButton(onClick = onNavigateToOverView) {
                Text("Go To Overview", fontWeight = FontWeight.Bold)
            }

        }
    }
}