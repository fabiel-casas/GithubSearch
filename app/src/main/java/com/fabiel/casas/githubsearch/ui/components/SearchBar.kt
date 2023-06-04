package com.fabiel.casas.githubsearch.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fabiel.casas.githubsearch.R
import com.fabiel.casas.githubsearch.ui.theme.GitHubSearchTheme

/**
 * GitHubSearch
 * Created on 04/06/2023.
 * Author: johan
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(
    modifier: Modifier,
    search: String,
    onSearchChange: (String) -> Unit,
    onSearchCloseAction: () -> Unit,
) {
    OutlinedTextField(
        modifier = modifier,
        value = search,
        onValueChange = onSearchChange,
        shape = CircleShape,
        leadingIcon = {
            Icon(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .requiredSize(24.dp),
                painter = painterResource(id = R.drawable.ic_search_24),
                contentDescription = stringResource(R.string.search_user),
                tint = MaterialTheme.colorScheme.onPrimaryContainer,
            )
        },
        singleLine = true,
        trailingIcon = {
            if (search.isNotEmpty()) {
                IconButton(onClick = onSearchCloseAction) {
                    Icon(
                        modifier = Modifier
                            .padding(horizontal = 16.dp)
                            .requiredSize(24.dp),
                        painter = painterResource(id = R.drawable.ic_close_24),
                        contentDescription = stringResource(R.string.close_search),
                        tint = MaterialTheme.colorScheme.onPrimaryContainer,
                    )
                }
            }
        },
        textStyle = MaterialTheme.typography.bodyLarge,
        placeholder = {
            Text(
                text = "Search a github user",
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                style = MaterialTheme.typography.bodyLarge,
            )
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
            disabledBorderColor = Color.Transparent,
            errorBorderColor = Color.Transparent,
            focusedBorderColor = Color.Transparent,
            unfocusedBorderColor = Color.Transparent,
            focusedLeadingIconColor = MaterialTheme.colorScheme.primary,
            unfocusedLeadingIconColor = MaterialTheme.colorScheme.primary,
            disabledLeadingIconColor = MaterialTheme.colorScheme.primary,
            errorLeadingIconColor = MaterialTheme.colorScheme.primary,
            textColor = MaterialTheme.colorScheme.onSurface
        )
    )
}

@Preview(showBackground = true)
@Composable
private fun SearchBarPreview() {
    GitHubSearchTheme {
        SearchBar(
            modifier = Modifier.fillMaxWidth(),
            search = "",
            onSearchChange = {},
            onSearchCloseAction = {}
        )
    }
}