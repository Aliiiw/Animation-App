package com.alirahimi.borutoapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import coil.annotation.ExperimentalCoilApi
import com.alirahimi.borutoapp.presentation.screens.Home.HomeScreen
import com.alirahimi.borutoapp.presentation.screens.search.SearchScreen
import com.alirahimi.borutoapp.presentation.screens.splash.SplashScreen
import com.alirahimi.borutoapp.presentation.screens.welcome.WelcomeScreen
import com.alirahimi.borutoapp.util.Constants.DETAILS_ARGUMENT_KEY

@OptIn(ExperimentalCoilApi::class)
@Composable
fun SetupNavGraph(navigationController: NavHostController) {

    NavHost(
        navController = navigationController,
        startDestination = Screen.Splash.route
    ) {
        composable(route = Screen.Splash.route) {
            SplashScreen(navigationController = navigationController)
        }

        composable(route = Screen.Welcome.route) {
            WelcomeScreen(navigationController = navigationController)
        }

        composable(route = Screen.Home.route) {
            HomeScreen(navigationController = navigationController)
        }

        composable(
            route = Screen.Details.route,
            arguments = listOf(navArgument(name = DETAILS_ARGUMENT_KEY) {
                type = NavType.IntType
            })
        ) {

        }

        composable(route = Screen.Search.route) {
            SearchScreen(navigationController = navigationController)
        }
    }
}