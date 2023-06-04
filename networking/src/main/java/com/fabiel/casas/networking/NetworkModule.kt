package com.fabiel.casas.networking

import com.fabiel.casas.networking.dataSource.GitHubDataSource
import com.fabiel.casas.networking.dataSource.GitHubDataSourceImpl
import com.fabiel.casas.networking.http.GitHubApi
import com.fabiel.casas.networking.http.RetrofitConfiguration
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * GitHubSearch
 * Created on 04/06/2023.
 * Author: johan
 */
val networkModule = module {
    factory {
        RetrofitConfiguration.build().create(GitHubApi::class.java)
    }
    factory<GitHubDataSource> {
        GitHubDataSourceImpl(get())
    }
}