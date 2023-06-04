package com.fabiel.casas.networking.http

import com.fabiel.casas.networking.http.response.SearchUserResponse
import com.fabiel.casas.networking.http.response.UserResponse
import com.fabiel.casas.networking.http.response.UserSearchResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


/**
 * GitHubSearch
 * Created on 04/06/2023.
 * Author: johan
 */
interface GitHubApi {
    @GET("search/users")
    suspend fun searchUser(@Query("q") search: String?): SearchUserResponse

    @GET("users/{userName}")
    suspend fun getUser(@Path("userName") userName: String?): UserResponse

    @GET("users")
    suspend fun getUsers(): List<UserSearchResponse>
}