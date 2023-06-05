package com.fabiel.casas.githubsearch.screens

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf

/**
 * GitHubSearch
 * Created on 04/06/2023.
 * Author: johan
 */
data class GitHubSearchUserState(
    val searchQuery: State<String> = mutableStateOf(""),
    val displayUserList: State<List<UserItem>> = mutableStateOf(emptyList<UserItem>()),
)

data class UserItem(
    val id: Int,
    val accountName: String,
    val avatarUrl: String,
)
