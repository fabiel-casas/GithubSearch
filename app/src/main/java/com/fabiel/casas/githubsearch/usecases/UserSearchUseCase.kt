package com.fabiel.casas.githubsearch.usecases

import com.fabiel.casas.githubsearch.screens.UserItem
import com.fabiel.casas.githubsearch.screens.details.UserDetails

/**
 * GitHubSearch
 * Created on 04/06/2023.
 * Author: johan
 */
interface UserSearchUseCase {
    suspend fun loadDefaultUsers(): List<UserItem>
    suspend fun searchUser(search: String): List<UserItem>

    suspend fun getUserDetails(userName: String): UserDetails
}