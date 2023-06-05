package com.fabiel.casas.githubsearch.navigation

/**
 * GitHubSearch
 * Created on 05/06/2023.
 * Author: johan
 */
sealed class NavDestinations(val route: String) {
    object Home: NavDestinations("home")
    object UserDetail: NavDestinations("userDetail")
}

fun NavDestinations.UserDetail.navRoute(userName: String): String {
    return "$route/$userName"
}
