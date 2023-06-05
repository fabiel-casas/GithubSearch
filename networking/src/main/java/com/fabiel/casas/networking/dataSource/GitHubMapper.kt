package com.fabiel.casas.networking.dataSource

import com.fabiel.casas.domain.GitHubUser
import com.fabiel.casas.networking.http.response.UserResponse
import com.fabiel.casas.networking.http.response.UserSearchResponse

/**
 * GitHubSearch
 * Created on 04/06/2023.
 * Author: johan
 */
class GitHubMapper {

    fun UserSearchResponse.toGitHubUser() = GitHubUser(
        id = id,
        avatarUrl = avatar_url,
        login = login,
        score = score,
        url = url
    )

    fun UserResponse.toGitHubUser() = GitHubUser(
        id = id,
        avatarUrl = avatar_url.orEmpty(),
        login = login,
        url = url.orEmpty(),
        score = following,
        bio = bio.orEmpty(),
        blog = blog.orEmpty(),
        company = company.orEmpty(),
        email = email.orEmpty(),
        followers = followers,
        following = following,
        location = location.orEmpty(),
        name = name.orEmpty(),
        publicGists = public_gists,
        publicRepos = public_repos,
        twitterUsername = twitter_username.orEmpty(),
    )
}