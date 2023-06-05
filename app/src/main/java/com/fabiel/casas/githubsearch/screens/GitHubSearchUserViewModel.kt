package com.fabiel.casas.githubsearch.screens

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fabiel.casas.githubsearch.usecases.UserSearchUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * GitHubSearch
 * Created on 04/06/2023.
 * Author: johan
 */
class GitHubSearchUserViewModel(
    private val userSearchUseCase: UserSearchUseCase
): ViewModel() {
    private val searchQuery= mutableStateOf("")
    private val displayUserList = mutableStateOf(emptyList<UserItem>())
    private var searchUserList = emptyList<UserItem>()
    private var defaultList = emptyList<UserItem>()
    val state = GitHubSearchUserState(
        searchQuery = searchQuery,
        displayUserList = displayUserList,
    )

    fun loadDefaultSearch() {
        if (searchQuery.value.isNotEmpty()) return
        viewModelScope.launch(Dispatchers.IO) {
            runCatching {
                userSearchUseCase.loadDefaultUsers()
            }.onSuccess {
                displayUserList.value = it
                defaultList = it
            }
        }
    }

    fun onSearchChange(search: String) {
        if (search.isEmpty()) {
            searchUserList = emptyList()
            displayUserList.value = defaultList
        } else {
            displayUserList.value =
                (defaultList.filter {
                    it.accountName.startsWith(search) || it.accountName.contains(search)
                } + searchUserList.filter {
                    it.accountName.startsWith(search) || it.accountName.contains(search)
                }).toSet().toList()
        }
        searchQuery.value = search
        viewModelScope.launch(Dispatchers.IO) {
            runCatching {
                userSearchUseCase.searchUser(search)
            }.onSuccess {
                searchUserList = it
                displayUserList.value = it
            }
        }
    }
}