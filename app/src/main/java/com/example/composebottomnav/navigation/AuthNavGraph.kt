package com.example.composebottomnav.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.composebottomnav.screens.auth.LoginScreen
import com.example.composebottomnav.screens.auth.ResetPasswordScreen
import com.example.composebottomnav.screens.auth.SignUpScreen


/**
 * The graph for authentication feature which will be nested in App Graph
 */
fun NavGraphBuilder.authNavGraph(navController: NavController) {
    navigation(
        route = Graph.AUTHENTICATION,
        startDestination = NoBottomBarScreens.Login.route
    ) {
        composable(route = NoBottomBarScreens.Login.route) {
            LoginScreen(
                onLoginClick = {
                    navController.popBackStack()
                    navController.navigate(Graph.HOME)
                },
                onSignUpClick = {
                    navController.navigate(NoBottomBarScreens.SignUp.route)
                },
                onResetPasswordClick = {
                    navController.navigate(NoBottomBarScreens.ResetPassword.route)
                }
            )
        }
        composable(route = NoBottomBarScreens.SignUp.route){
            SignUpScreen(){
                navController.popBackStack()
            }
        }

        composable(route = NoBottomBarScreens.ResetPassword.route){
            ResetPasswordScreen(){
                navController.popBackStack()
            }
        }
    }
}