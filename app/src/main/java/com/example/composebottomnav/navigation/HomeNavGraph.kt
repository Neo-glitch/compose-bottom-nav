package com.example.composebottomnav.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composebottomnav.screens.home.HomeScreen

@Composable
fun HomeNavGraph(paddingValues: PaddingValues, rootNavController: NavHostController) {
    // to implement nested nav Graph, for a tab in bottom nav
    // contain a NavHost and not a screen, similar to Flutter Navigator implementation
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        route = BottomBarScreen.Home.route,
        startDestination = "/"
    ) {
        composable(route = "/") {
            HomeScreen(
                paddingValues,
                onGoToDetailsClick = {
                    navController.navigate(Graph.DETAILS)
                },
                onGoToSettingsClick = {
                    rootNavController.navigate(BottomBarScreen.Settings.route) {
                        // allows us pop to startDestination on back press
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            ) {
                rootNavController.navigate(NoBottomBarScreens.NewFeature.route)
            }
        }
        detailsNavGraph(navController)
    }
}