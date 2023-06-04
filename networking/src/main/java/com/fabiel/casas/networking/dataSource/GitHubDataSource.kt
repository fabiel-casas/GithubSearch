package com.fabiel.casas.networking.dataSource

import com.fabiel.casas.domain.GitHubUser

/**
 * GitHubSearch
 * Created on 04/06/2023.
 * Author: johan
 */
interface GitHubDataSource {

    suspend fun searchUser(search: String?): List<GitHubUser>
    suspend fun getUser(userName: String): GitHubUser
    suspend fun getUsers(): List<GitHubUser>
}