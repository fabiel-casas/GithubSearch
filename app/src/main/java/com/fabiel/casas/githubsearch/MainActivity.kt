package com.fabiel.casas.githubsearch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.fabiel.casas.githubsearch.screens.GitHubSearchUserScreen
import com.fabiel.casas.githubsearch.ui.theme.GitHubSearchTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GitHubSearchTheme {
                GitHubSearchUserScreen()
            }
        }
    }
}