package com.example.composebottomnav.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class NoBottomBarScreens(val route: String) {
    data object Login : NoBottomBarScreens("LOGIN")
    data object SignUp : NoBottomBarScreens("SIGN_UP")
    data object ResetPassword : NoBottomBarScreens("RESET_PASSWORD")
    data object NewFeature: NoBottomBarScreens("NEW_FEATURE")
}

sealed class BottomBarScreen(
    val route: String,
    val title: String,    // title / label to be show in bottom nav
    val icon: ImageVector // icon to be shown in bottom nav
){
    data object Home: BottomBarScreen(
        route = "home",
        title = "Home",
        icon = Icons.Default.Home
    )

    data object Profile: BottomBarScreen(
        route = "profile",
        title = "Profile",
        icon = Icons.Default.Person
    )

    data object Settings: BottomBarScreen(
        route = "settings",
        title = "Settings",
        icon = Icons.Default.Settings
    )
}


sealed class DetailsScreen(val route: String) {
    data object Information : DetailsScreen(route = "INFORMATION")
    data object Overview : DetailsScreen(route = "OVERVIEW")
}