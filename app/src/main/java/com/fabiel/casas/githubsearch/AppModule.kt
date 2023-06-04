package com.fabiel.casas.githubsearch

import com.fabiel.casas.githubsearch.screens.GitHubSearchUserViewModel
import com.fabiel.casas.githubsearch.usecases.UserSearchUseCase
import com.fabiel.casas.githubsearch.usecases.UserSearchUseCaseImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * GitHubSearch
 * Created on 04/06/2023.
 * Author: johan
 */
val appModule = module {
    factory<UserSearchUseCase> {
        UserSearchUseCaseImpl(get())
    }
    viewModel {
        GitHubSearchUserViewModel(get())
    }
}