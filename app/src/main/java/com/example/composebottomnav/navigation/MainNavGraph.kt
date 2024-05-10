package com.example.composebottomnav.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.composebottomnav.screens.home.HomeDetailScreen
import com.example.composebottomnav.screens.home.HomeOverviewScreen
import com.example.composebottomnav.screens.home.NewFeatureScreen
import com.example.composebottomnav.screens.home.ProfileScreen
import com.example.composebottomnav.screens.home.SettingsScreen

@Composable
fun MainNavGraph(navHostController: NavHostController, paddingValues: PaddingValues) {
    NavHost(
        route = Graph.HOME,
        navController = navHostController,
        startDestination = BottomBarScreen.Home.route
    ) {
        // all screens in the navGraph
        composable(route = BottomBarScreen.Home.route) {
//            HomeScreen(paddingValues){
//                navHostController.navigate(Graph.DETAILS)
//            }
            HomeNavGraph(paddingValues = paddingValues, rootNavController = navHostController)
        }
        composable(route = BottomBarScreen.Profile.route) {
            ProfileScreen(paddingValues)
        }

        composable(route = BottomBarScreen.Settings.route) {
            SettingsScreen(paddingValues)
        }

        composable(route = NoBottomBarScreens.NewFeature.route){
            NewFeatureScreen()
        }


        // screen not in the navGraph
        detailsNavGraph(navHostController)
    }
}


/**
 * nested nav Graph to be accessed by home screen
 */
fun NavGraphBuilder.detailsNavGraph(navController: NavHostController){
    navigation(
        route = Graph.DETAILS,
        startDestination = DetailsScreen.Information.route
    ){
        composable(route = DetailsScreen.Information.route){
            HomeDetailScreen {
                navController.navigate(DetailsScreen.Overview.route)
            }
        }

        composable(DetailsScreen.Overview.route){
            HomeOverviewScreen{
                navController.popBackStack()
            }
        }
    }
}

