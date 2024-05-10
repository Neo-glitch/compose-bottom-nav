package com.example.composebottomnav.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.composebottomnav.screens.home.MainScreen

@Composable
fun AppNavGraph(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        route = Graph.ROOT,
        startDestination = Graph.AUTHENTICATION
    ) {
        authNavGraph(navHostController)
        composable(route = Graph.HOME){
            MainScreen()
        }
    }
}

object Graph {
    const val ROOT = "root_graph"
    const val AUTHENTICATION = "auth_graph"
    const val HOME = "home_graph"
    const val DETAILS = "home_details_graph"
}