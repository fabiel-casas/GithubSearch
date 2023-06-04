package com.fabiel.casas.networking.dataSource

import com.fabiel.casas.domain.GitHubUser
import com.fabiel.casas.networking.http.GitHubApi

/**
 * GitHubSearch
 * Created on 04/06/2023.
 * Author: johan
 */
internal class GitHubDataSourceImpl(
    private val gitHubApi: GitHubApi
): GitHubDataSource {
    private val mapper = GitHubMapper()
    override suspend fun searchUser(search: String?): List<GitHubUser> {
        return with(mapper) {
            gitHubApi.searchUser(search).items.map {
                it.toGitHubUser()
            }
        }
    }

    override suspend fun getUser(userName: String): GitHubUser {
        return with(mapper){
            gitHubApi.getUser(userName).toGitHubUser()
        }
    }

    override suspend fun getUsers(): List<GitHubUser> {
        return with(mapper) {
            gitHubApi.getUsers().map { it.toGitHubUser() }
        }
    }
}