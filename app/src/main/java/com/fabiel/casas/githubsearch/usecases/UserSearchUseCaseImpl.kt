package com.fabiel.casas.githubsearch.usecases

import com.fabiel.casas.domain.GitHubUser
import com.fabiel.casas.githubsearch.screens.UserItem
import com.fabiel.casas.githubsearch.screens.details.UserDetails
import com.fabiel.casas.githubsearch.tools.prettyCount
import com.fabiel.casas.networking.dataSource.GitHubDataSource

/**
 * GitHubSearch
 * Created on 04/06/2023.
 * Author: johan
 */
class UserSearchUseCaseImpl(
    private val gitHubDataSource: GitHubDataSource
) : UserSearchUseCase {
    override suspend fun loadDefaultUsers(): List<UserItem> {
        return gitHubDataSource.getUsers().map { it.toUserItem() }
    }

    override suspend fun searchUser(search: String): List<UserItem> {
        return gitHubDataSource.searchUser(search).map { it.toUserItem() }
    }

    private fun GitHubUser.toUserItem() = UserItem(
        id = id,
        accountName = login,
        avatarUrl = avatarUrl,
    )

    private fun GitHubUser.toUserDetails() = UserDetails(
        id = id,
        accountName = login,
        avatarUrl = avatarUrl,
        followers = prettyCount(followers),
        following = prettyCount(following),
        name = name,
        bio = bio,
        company = company,
        location = location,
        email = email,
        blog = blog,
        twitter = twitterUsername,
    )

    override suspend fun getUserDetails(userName: String): UserDetails {
        return gitHubDataSource.getUser(userName).toUserDetails()
    }
}