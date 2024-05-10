package com.example.composebottomnav.screens.home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.composebottomnav.navigation.BottomBarScreen
import com.example.composebottomnav.navigation.MainNavGraph
import com.example.composebottomnav.navigation.NoBottomBarScreens


/**
 * Host Screen for Bottom NavBar
 */
@Preview(showSystemUi = true, showBackground = true)
@Composable
fun MainScreen() {
    // for navigating between the tab items only
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomBar(navController)
        }
    ) { paddingValues ->
        MainNavGraph(navHostController = navController, paddingValues)
    }
}


@Composable
fun BottomBar(navController: NavController) {
    // screens associated with bottomNav
    val screens = listOf(
        BottomBarScreen.Home,
        BottomBarScreen.Profile,
        BottomBarScreen.Settings,
    )

    // to listen to when backstack of this controller changes
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    AnimatedVisibility(
        visible = currentDestination?.route != NoBottomBarScreens.NewFeature.route,
        enter =  slideInHorizontally() + fadeIn(),
        exit = slideOutHorizontally() + fadeOut()
    ) {
        NavigationBar {
            screens.forEach { screen ->
                AddItem(
                    screen = screen,
                    currentDestination = currentDestination,
                    navController = navController
                )
            }
        }
    }

}

// to add bottom navBar items in row
@Composable
fun RowScope.AddItem(
    screen: BottomBarScreen,
    currentDestination: NavDestination?,
    navController: NavController
) {
    NavigationBarItem(
        label = { Text(text = screen.title) },
        // to check if nav Destination is current route destination
        selected = currentDestination?.hierarchy?.any {
            it.route == screen.route
        } ?: false,
        onClick = {
            navController.navigate(screen.route){
                // allows us pop to startDestination on back press
                popUpTo(navController.graph.findStartDestination().id){
                    saveState = true
                }
                launchSingleTop = true
                restoreState = true
            }
        },
        colors = NavigationBarItemDefaults.colors(
            unselectedIconColor = LocalContentColor.current.copy(alpha = 0.5f),
            unselectedTextColor = LocalContentColor.current.copy(alpha = 0.5f)
        ),
        icon = {
            Icon(imageVector = screen.icon, contentDescription = null)
        },
    )
}