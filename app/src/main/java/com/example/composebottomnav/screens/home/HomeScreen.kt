package com.example.composebottomnav.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.unit.dp

/**
 * Bottom Nav Bar Screen
 */
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreen(
    paddingValues: PaddingValues = PaddingValues(),
    onGoToDetailsClick: () -> Unit = {},
    onGoToSettingsClick: () -> Unit = {},
    onGoToNewFeatureClick: () -> Unit = {}
) {
    Column(
        Modifier
            .padding(paddingValues)
            .fillMaxSize()
            .background(Color.Blue),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        TextButton(onClick = onGoToDetailsClick) {
            Text("To Home Details", color = Color.White, fontWeight = FontWeight.Bold, fontSize = MaterialTheme.typography.headlineMedium.fontSize)
        }

        Spacer(modifier = Modifier.height(20.dp))

        TextButton(onClick = onGoToSettingsClick) {
            Text("To Settings NavBar Item", color = Color.White, fontWeight = FontWeight.Bold, fontSize = MaterialTheme.typography.headlineMedium.fontSize)
        }

        Spacer(modifier = Modifier.height(20.dp))

        TextButton(onClick = onGoToNewFeatureClick) {
            Text("To New Feature No Nav Bar", color = Color.White, fontWeight = FontWeight.Bold, fontSize = MaterialTheme.typography.headlineMedium.fontSize)
        }
    }
}