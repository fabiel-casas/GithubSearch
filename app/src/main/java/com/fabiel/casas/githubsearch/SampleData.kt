package com.fabiel.casas.githubsearch

import com.fabiel.casas.githubsearch.screens.UserItem
import com.fabiel.casas.githubsearch.screens.details.UserDetails

/**
 * GitHubSearch
 * Created on 05/06/2023.
 * Author: johan
 */
object SampleData {
    const val userDetailName = "Fabiel Casas"
    const val userDetailsAcountName = "fabiel-casas"
    const val userDetailsAvatar = "https://avatars.githubusercontent.com/u/4743259?v=4"
    const val userDetailsBio = "Android Developer"
    const val userDetailsLocation = "Amsterdam, Netherlans"
    const val userDetailsEmail = "fabiel016_@hotmail.com"
    const val userDetailsBlog = "fabielcasas.nl"
    const val userDetailsTwitter = "fabiel016"
    const val userDetailsFollowers = "8"
    const val userDetailsFollowing = "13"

    private const val userDetailsId = 4743259
    val userDetails = UserDetails(
        id = userDetailsId,
        name = userDetailName,
        accountName = userDetailsAcountName,
        avatarUrl = userDetailsAvatar,
        bio = userDetailsBio,
        company = "",
        location = userDetailsLocation,
        email = userDetailsEmail,
        blog = userDetailsBlog,
        twitter = userDetailsTwitter,
        followers = userDetailsFollowers,
        following = userDetailsFollowing
    )

    val userItems = listOf(
        UserItem(
            id = 1,
            accountName = "mojombo",
            avatarUrl = "https://avatars.githubusercontent.com/u/1?v=4",
        ),
        UserItem(
            id = 2,
            accountName = "defunkt",
            avatarUrl = "https://avatars.githubusercontent.com/u/2?v=4",
        ),
        UserItem(
            id = 3,
            accountName = "pjhyett",
            avatarUrl = "https://avatars.githubusercontent.com/u/3?v=4",
        )
    )

    val searchResult = listOf(
        UserItem(
            id = 66577,
            accountName = "JakeWharton",
            avatarUrl = "https://avatars.githubusercontent.com/u/66577?v=4",
        ),
    )
}