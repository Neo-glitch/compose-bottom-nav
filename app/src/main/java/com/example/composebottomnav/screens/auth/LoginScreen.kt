package com.example.composebottomnav.screens.auth

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
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
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginScreen(
    onLoginClick: () -> Unit = {},
    onSignUpClick: () -> Unit = {},
    onResetPasswordClick: () -> Unit = {}
) {
    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier.shadow(elevation = 3.dp),
                title = { Text("Login Screen") }
            )
        }
    ) { paddingValues ->
        Column(
            Modifier.padding(paddingValues)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextButton(onClick = onLoginClick) {
                Text("Login", fontWeight = FontWeight.Bold)
            }
            Spacer(Modifier.height(40.dp))
            TextButton(onClick = onSignUpClick) {
                Text("SignUp", fontWeight = FontWeight.Bold)
            }
            Spacer(Modifier.height(40.dp))
            TextButton(onClick = onResetPasswordClick) {
                Text("Reset Password", fontWeight = FontWeight.Bold)
            }
        }
    }

}