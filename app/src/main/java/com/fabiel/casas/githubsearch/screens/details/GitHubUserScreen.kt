package com.fabiel.casas.githubsearch.screens.details

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.AssistChip
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.size.Scale
import com.fabiel.casas.githubsearch.R
import com.fabiel.casas.githubsearch.ui.theme.GitHubSearchTheme
import org.koin.androidx.compose.getViewModel

/**
 * GitHubSearch
 * Created on 05/06/2023.
 * Author: johan
 */
@Composable
fun GitHubUserScreen(
    viewModel: GitHubUserViewModel = getViewModel(),
    userName: String,
    onBackAction: () -> Unit,
    onIntentAction: (Intent) -> Unit,
) {
    LaunchedEffect(key1 = userName, block = {
        viewModel.loadUserDetails(userName)
    })
    GitHubUserContent(
        state = viewModel.state,
        onBackAction = onBackAction,
        onIntentAction = onIntentAction
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun GitHubUserContent(
    state: GitHubUserState,
    onBackAction: () -> Unit,
    onIntentAction: (Intent) -> Unit
) {
    Scaffold(
        topBar = {
            Row(
                modifier = Modifier
                    .padding(vertical = 8.dp)
                    .fillMaxWidth(),
            ) {
                IconButton(onClick = onBackAction) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "")
                }
            }
        },
        bottomBar = {
            state.user.value?.let {
                RowOfChips(it, onIntentAction)
            }
        }
    ) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {
            if (state.isLoading.value) {
                Box(modifier = Modifier.fillMaxSize()) {
                    CircularProgressIndicator(
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
            } else {
                state.user.value?.let {
                    ProfileHeader(it)
                }
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = state.user.value?.name.orEmpty(),
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Center,
                )
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = state.user.value?.accountName.orEmpty(),
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.outline,
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Center,
                )
                if (state.user.value?.company?.isNotEmpty() == true) {
                    ProfileAttributes(
                        text = state.user.value?.company.orEmpty(),
                        iconRes = R.drawable.ic_work_24
                    )
                }
                if (state.user.value?.location?.isNotEmpty() == true) {
                    ProfileAttributes(
                        text = state.user.value?.location.orEmpty(),
                        iconRes = R.drawable.ic_location_on_24
                    )
                }
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    text = state.user.value?.bio.orEmpty(),
                    textAlign = TextAlign.Justify,
                )
            }
        }
    }
}

@Composable
fun ProfileAttributes(
    text: String,
    iconRes: Int,
) {
    Row(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(painter = painterResource(id = iconRes), contentDescription = null)
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            text = text,
            textAlign = TextAlign.Start,
        )
    }
}

@Composable
private fun RowOfChips(
    user: UserDetails,
    onIntentAction: (Intent) -> Unit
) {
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        content = {
            if (user.email.isNotEmpty()) {
                item {
                    ChipItem(
                        text = user.email,
                        icon = R.drawable.ic_email_24,
                        onChipAction = {
                            onIntentAction(
                                Intent(Intent.ACTION_SENDTO).apply {
                                    data = Uri.parse("mailto:")
                                    putExtra(Intent.EXTRA_EMAIL, user.email)
                                }
                            )
                        }
                    )
                }
            }
            if (user.blog.isNotEmpty()) {
                item {
                    ChipItem(
                        text = user.blog,
                        icon = R.drawable.ic_link_24,
                        onChipAction = {
                            onIntentAction(
                                Intent(Intent.ACTION_VIEW).apply {
                                    data = Uri.parse(user.toBlogLink())
                                }
                            )
                        }
                    )
                }
            }
            if (user.twitter.isNotEmpty()) {
                item {
                    ChipItem(
                        text = user.twitter,
                        icon = R.drawable.ic_twitter,
                        onChipAction = {
                            onIntentAction(
                                Intent(
                                    Intent.ACTION_VIEW,
                                    Uri.parse("https://twitter.com/${user.twitter}")
                                )
                            )
                        }
                    )
                }
            }
            item {
                Spacer(modifier = Modifier.width(16.dp))
            }
        })
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun ChipItem(
    text: String,
    icon: Int,
    onChipAction: () -> Unit,
) {
    Spacer(modifier = Modifier.width(16.dp))
    AssistChip(
        onClick = onChipAction,
        label = {
            Text(text = text)
        },
        leadingIcon = {
            Icon(
                modifier = Modifier.requiredSize(24.dp),
                painter = painterResource(id = icon),
                contentDescription = null
            )
        }
    )

}

@Composable
private fun ProfileHeader(userDetails: UserDetails) {
    ConstraintLayout(
        modifier = Modifier.fillMaxWidth()
    ) {
        val (followers, profile, following) = createRefs()
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(userDetails.avatarUrl)
                .crossfade(true)
                .error(R.drawable.ic_account_circle_24)
                .placeholder(R.drawable.ic_account_circle_24)
                .scale(Scale.FIT)
                .build(),
            modifier = Modifier
                .constrainAs(profile) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                }
                .requiredSize(145.dp)
                .border(
                    border = BorderStroke(
                        3.dp,
                        color = MaterialTheme.colorScheme.primary
                    ), shape = CircleShape
                )
                .padding(6.dp)
                .clip(CircleShape),
            contentDescription = null,
        )
        FollowContainer(
            modifier = Modifier.constrainAs(followers) {
                start.linkTo(parent.start)
                end.linkTo(profile.start)
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
            },
            value = userDetails.followers,
            description = stringResource(R.string.followers)
        )
        FollowContainer(
            modifier = Modifier.constrainAs(following) {
                start.linkTo(profile.end)
                end.linkTo(parent.end)
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
            },
            value = userDetails.following,
            description = stringResource(R.string.following)
        )

    }
}

@Composable
private fun FollowContainer(
    modifier: Modifier,
    value: String,
    description: String
) {
    Column(modifier = modifier) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = value,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
        )
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = description,
            style = MaterialTheme.typography.labelLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            textAlign = TextAlign.Center,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun GitHubUserContentPreview() {
    GitHubSearchTheme {
        val state = remember {
            GitHubUserState()
        }
        GitHubUserContent(
            state = state,
            onBackAction = {},
            onIntentAction = {}
        )
    }
}