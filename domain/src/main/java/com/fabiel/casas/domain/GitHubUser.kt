package com.fabiel.casas.domain

/**
 * GitHubSearch
 * Created on 04/06/2023.
 * Author: johan
 */
data class GitHubUser(
    val id: Int,
    val avatarUrl: String,
    val login: String,
    val score: Int,
    val url: String,
    // Detail information
    val bio: String = "",
    val blog: String = "",
    val company: String = "",
    val email: String = "",
    val followers: Int = 0,
    val following: Int = 0,
    val location: String = "",
    val name: String = "",
    val publicGists: Int = 0,
    val publicRepos: Int = 0,
    val twitterUsername: String = "",
)
