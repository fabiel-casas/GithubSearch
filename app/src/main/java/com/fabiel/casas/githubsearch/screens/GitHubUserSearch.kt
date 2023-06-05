package com.fabiel.casas.githubsearch.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fabiel.casas.githubsearch.SampleData
import com.fabiel.casas.githubsearch.ui.components.SearchBar
import com.fabiel.casas.githubsearch.ui.components.UserRow
import com.fabiel.casas.githubsearch.ui.theme.GitHubSearchTheme
import org.koin.androidx.compose.getViewModel

/**
 * GitHubSearch
 * Created on 04/06/2023.
 * Author: johan
 */
@Composable
fun GitHubSearchUserScreen(
    viewModel: GitHubSearchUserViewModel = getViewModel(),
    onNavigateToUserDetails:(userName: String) -> Unit,
) {
    LaunchedEffect(key1 = viewModel, block = {
        viewModel.loadDefaultSearch()
    })
    GitHubSearchUserContent(
        state = viewModel.state,
        onSearchChange = {
            viewModel.onSearchChange(it)
        },
        onSearchCloseAction = {
            viewModel.onSearchChange("")
        },
        onNavigateToUserDetails = onNavigateToUserDetails
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GitHubSearchUserContent(
    state: GitHubSearchUserState,
    onSearchChange: (String) -> Unit,
    onNavigateToUserDetails: (String) -> Unit,
    onSearchCloseAction: () -> Unit,
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            Surface(
                modifier = Modifier.fillMaxWidth(),
                color = MaterialTheme.colorScheme.primary,
            ) {
                SearchBar(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                    search = state.searchQuery.value,
                    onSearchChange = onSearchChange,
                    onSearchCloseAction = onSearchCloseAction
                )
            }
        }
    ) { contentPadding ->
        LazyColumn(
            contentPadding = contentPadding,
            content = {
                items(state.displayUserList.value) { user ->
                    UserRow(
                        modifier = Modifier
                            .clickable {
                                onNavigateToUserDetails(user.accountName)
                            }
                            .padding(horizontal = 16.dp, vertical = 8.dp)
                            .fillMaxWidth(),
                        avatarUrl = user.avatarUrl,
                        userName = user.accountName
                    )
                }
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun GitHubSearchUserContentPreview() {
    GitHubSearchTheme {
        GitHubSearchUserContent(
            state = remember { GitHubSearchUserState(
                displayUserList = mutableStateOf(SampleData.userItems)
            ) },
            onSearchChange = {},
            onSearchCloseAction = {},
            onNavigateToUserDetails = {}
        )
    }
}