package com.fabiel.casas.githubsearch

import com.fabiel.casas.domain.GitHubUser
import com.fabiel.casas.githubsearch.screens.details.UserDetails

/**
 * GitHubSearch
 * Created on 05/06/2023.
 * Author: johan
 */
object DummyData {
    val defaultUserList = listOf(
        GitHubUser(
            login = "mojombo",
            id = 1,
            avatarUrl = "https://avatars.githubusercontent.com/u/1?v=4",
            url = "https://api.github.com/users/mojombo",
        ),
        GitHubUser(
            login = "defunkt",
            id = 2,
            avatarUrl = "https://avatars.githubusercontent.com/u/2?v=4",
            url = "https://api.github.com/users/defunkt",
        ),
        GitHubUser(
            login = "pjhyett",
            id = 3,
            avatarUrl = "https://avatars.githubusercontent.com/u/3?v=4",
            url = "https://api.github.com/users/pjhyett",
        )
    )

    val userDetails = GitHubUser(
        login = "fabiel-casas",
        id = 4743259,
        avatarUrl = "https://avatars.githubusercontent.com/u/4743259?v=4",
        url = "https://api.github.com/users/fabiel-casas",
        name = "Fabiel Casas",
        company = "",
        blog = "fabielcasas.nl",
        location = "Amsterdam, Netherlans",
        email = "fabiel016_@hotmail.com",
        bio = "Android Developer",
        twitterUsername = "fabiel016",
        publicRepos = 30,
        publicGists = 0,
        followers = 8,
        following = 13,
    )

    val userDetailsJake = GitHubUser(
        login = "JakeWharton",
        id = 66577,
        avatarUrl = "https://avatars.githubusercontent.com/u/66577?v=4",
        url = "https://api.github.com/users/JakeWharton",
        name = "Jake Wharton",
        company = "@cashapp / @square",
        blog = "jakewharton.com",
        location = "Pittsburgh, PA, USA",
        email = "j@ke.fyi",
        bio = "",
        twitterUsername = "",
        publicRepos = 128,
        publicGists = 54,
        followers = 65440,
        following = 9,
    )
    val userDetailsJakeWharton = UserDetails(
        id = 66577, name = "Jake Wharton",
        accountName = "JakeWharton",
        avatarUrl = "https://avatars.githubusercontent.com/u/66577?v=4",
        bio = "",
        company = "@cashapp / @square",
        location = "Pittsburgh, PA, USA",
        email = "j@ke.fyi",
        blog = "jakewharton.com",
        twitter = "",
        followers = "65.4k",
        following = "9"
    )
    val definitiveList: List<GitHubUser> = defaultUserList + listOf(userDetails, userDetailsJake)
}