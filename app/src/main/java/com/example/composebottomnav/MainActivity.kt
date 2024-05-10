package com.example.composebottomnav

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.composebottomnav.navigation.AppNavGraph
import com.example.composebottomnav.screens.home.MainScreen
import com.example.composebottomnav.ui.theme.ComposeBottomNavTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeBottomNavTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    MainScreen()
                    AppNavGraph(navHostController = rememberNavController())
                }
            }
        }
    }
}

