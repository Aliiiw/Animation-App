package com.alirahimi.borutoapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.alirahimi.borutoapp.util.Constants.DETAILS_ARGUMENT_KEY

@Composable
fun SetupNavGraph(navigationController: NavHostController) {

    NavHost(
        navController = navigationController,
        startDestination = Screen.Splash.route
    ) {
        composable(route = Screen.Splash.route) {

        }

        composable(route = Screen.Welcome.route) {

        }

        composable(route = Screen.Home.route) {

        }

        composable(
            route = Screen.Details.route,
            arguments = listOf(navArgument(name = DETAILS_ARGUMENT_KEY) {
                type = NavType.IntType
            })
        ) {

        }

        composable(route = Screen.Search.route) {

        }
    }
}