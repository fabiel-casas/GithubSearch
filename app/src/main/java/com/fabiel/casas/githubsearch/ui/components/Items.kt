package com.fabiel.casas.githubsearch.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.fabiel.casas.githubsearch.R
import com.fabiel.casas.githubsearch.ui.theme.GitHubSearchTheme

/**
 * GitHubSearch
 * Created on 04/06/2023.
 * Author: johan
 */
@Composable
fun UserRow(
    modifier: Modifier,
    avatarUrl: String,
    userName: String,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(avatarUrl)
                .crossfade(true)
                .error(R.drawable.ic_account_circle_24)
                .placeholder(R.drawable.ic_account_circle_24)
                .build(),
            modifier = Modifier
                .requiredSize(40.dp)
                .clip(CircleShape),
            contentDescription = userName,
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(
                text = userName,
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun UserItemPreview() {
    GitHubSearchTheme {
        UserRow(
            modifier = Modifier.fillMaxWidth(),
            userName = "Sample text user name",
            avatarUrl = ""
        )
    }
}