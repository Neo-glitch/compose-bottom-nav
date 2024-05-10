package com.example.composebottomnav.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview


/**
 * Bottom Nav Bar Screen
 */
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ProfileScreen(paddingValues: PaddingValues = PaddingValues()) {

    Box(
        Modifier
            .padding(paddingValues)
            .fillMaxSize()
            .background(Color.Green),
        contentAlignment = Alignment.Center
    ){
        TextButton(onClick = { }) {
            Text("To Profile Details", color = Color.White, fontWeight = FontWeight.Bold, fontSize = MaterialTheme.typography.headlineMedium.fontSize)
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ProfileDetailsScreen(){

    Box(
        Modifier
            .fillMaxSize()
            .background(Color.Green),
        contentAlignment = Alignment.Center
    ){
        Text("Profile Details", color = Color.White, fontWeight = FontWeight.Bold, fontSize = MaterialTheme.typography.headlineMedium.fontSize)
    }
}