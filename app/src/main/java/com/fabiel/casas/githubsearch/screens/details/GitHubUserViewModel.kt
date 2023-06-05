package com.fabiel.casas.githubsearch.screens.details

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fabiel.casas.githubsearch.usecases.UserSearchUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * GitHubSearch
 * Created on 05/06/2023.
 * Author: johan
 */
class GitHubUserViewModel(
    private val userSearchUseCase: UserSearchUseCase,
) : ViewModel() {

    private val user = mutableStateOf<UserDetails?>(null)
    private val loading = mutableStateOf(false)
    val state = GitHubUserState(
        user = user,
        isLoading = loading
    )

    fun loadUserDetails(userName: String) {
        loading.value = true
        viewModelScope.launch(Dispatchers.IO) {
            runCatching {
                userSearchUseCase.getUserDetails(userName)
            }.onSuccess {
                user.value = it
                loading.value = false
            }.onFailure {
                loading.value = false
                it.printStackTrace()
            }
        }
    }
}