package com.fabiel.casas.githubsearch.screens.details

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf

/**
 * GitHubSearch
 * Created on 05/06/2023.
 * Author: johan
 */
data class GitHubUserState(
    val user: State<UserDetails?> = mutableStateOf(null),
    val isLoading: State<Boolean> = mutableStateOf(false),
)

data class UserDetails(
    val id: Int,
    val name: String,
    val accountName: String,
    val avatarUrl: String,
    val bio: String,
    val company: String,
    val location: String,
    val email: String,
    val blog: String,
    val twitter: String,
    val followers: String,
    val following: String,
)

fun UserDetails.toBlogLink() = if (!blog.contains("http")) {
    "https://$blog"
} else {
    blog
}