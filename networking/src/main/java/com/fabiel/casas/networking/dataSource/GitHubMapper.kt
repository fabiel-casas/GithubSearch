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
        followersUrl = followers_url,
        followingUrl = following_url,
        gistsUrl = gists_url,
        htmlUrl = html_url,
        login = login,
        organizationsUrl = organizations_url,
        received_eventsUrl = received_events_url,
        reposUrl = repos_url,
        score = score,
        site_admin = site_admin,
        starredUrl = starred_url,
        type = type,
        url = url
    )

    fun UserResponse.toGitHubUser() = GitHubUser(
        id = id,
        avatarUrl = avatar_url,
        followersUrl = followers_url,
        followingUrl = following_url,
        gistsUrl = gists_url,
        htmlUrl = html_url,
        login = login,
        organizationsUrl = organizations_url,
        received_eventsUrl = received_events_url,
        reposUrl = repos_url,
        site_admin = site_admin,
        starredUrl = starred_url,
        type = type,
        url = url,
        score = following
    )
}