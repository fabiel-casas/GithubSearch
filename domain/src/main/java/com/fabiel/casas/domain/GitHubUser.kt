package com.fabiel.casas.domain

/**
 * GitHubSearch
 * Created on 04/06/2023.
 * Author: johan
 */
data class GitHubUser(
    val id: Int,
    val avatarUrl: String,
    val followersUrl: String,
    val followingUrl: String,
    val gistsUrl: String,
    val htmlUrl: String,
    val login: String,
    val organizationsUrl: String,
    val received_eventsUrl: String,
    val reposUrl: String,
    val score: Int,
    val site_admin: Boolean,
    val starredUrl: String,
    val type: String,
    val url: String
)
