package com.fabiel.casas.githubsearch

import android.app.Application
import com.fabiel.casas.networking.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

/**
 * GitHubSearch
 * Created on 04/06/2023.
 * Author: johan
 */
class GitHubSearchApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@GitHubSearchApplication)
            modules(appModule, networkModule)
        }
    }
}