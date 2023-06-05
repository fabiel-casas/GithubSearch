package com.fabiel.casas.githubsearch

import com.fabiel.casas.domain.GitHubUser
import com.fabiel.casas.networking.dataSource.GitHubDataSource

/**
 * GitHubSearch
 * Created on 05/06/2023.
 * Author: johan
 */
class GitHubDataSourceFake : GitHubDataSource {
    override suspend fun searchUser(search: String?): List<GitHubUser> {
        return DummyData.definitiveList.filter { user ->
            search?.let {
                user.login.startsWith(search)
            } ?: true
        }
    }

    override suspend fun getUser(userName: String): GitHubUser {
        return DummyData.definitiveList.first {
            it.login == userName
        }
    }

    override suspend fun getUsers(): List<GitHubUser> {
        return DummyData.defaultUserList
    }

}