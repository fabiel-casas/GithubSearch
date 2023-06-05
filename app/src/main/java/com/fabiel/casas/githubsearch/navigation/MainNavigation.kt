package com.fabiel.casas.githubsearch.navigation

import android.content.Intent
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.fabiel.casas.githubsearch.screens.GitHubSearchUserScreen
import com.fabiel.casas.githubsearch.screens.details.GitHubUserScreen

/**
 * GitHubSearch
 * Created on 05/06/2023.
 * Author: johan
 */
@Composable
fun MainNavigation(
    onIntentAction: (Intent) -> Unit
) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = NavDestinations.Home.route,
        builder = {
            composable(route = NavDestinations.Home.route) {
                GitHubSearchUserScreen(
                    onNavigateToUserDetails = { userName ->
                        navController.navigate(route = NavDestinations.UserDetail.navRoute(userName))
                    }
                )
            }
            composable(
                route = "${NavDestinations.UserDetail.route}/{userName}",
                arguments = listOf(navArgument("userName") { type = NavType.StringType })
            ) { navBackStackEntry ->
                GitHubUserScreen(
                    userName = navBackStackEntry.arguments?.getString("userName").orEmpty(),
                    onBackAction = {
                        navController.popBackStack()
                    },
                    onIntentAction = onIntentAction
                )
            }
        }
    )
}