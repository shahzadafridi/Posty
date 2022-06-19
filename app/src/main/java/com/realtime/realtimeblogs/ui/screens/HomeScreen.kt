package com.realtime.realtimeblogs.ui.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.accompanist.insets.LocalWindowInsets
import com.google.accompanist.insets.navigationBarsPadding
import com.google.accompanist.insets.rememberInsetsPaddingValues
import com.realtime.realtimeblogs.data.Repository
import com.realtime.realtimeblogs.ui.components.InsetAwareTopAppBar
import com.realtime.realtimeblogs.ui.components.topAppBarIcon
import com.realtime.realtimeblogs.ui.components.topAppBarTitle
import com.realtime.realtimeblogs.ui.items.PostCard

@Composable
fun HomeTabScreen(
    postsRepository: Repository,
    scaffoldState: ScaffoldState,
    navigateToPostDetail: (String) -> Unit
) {
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            InsetAwareTopAppBar(
                title = topAppBarTitle(title = "Home"),
                navigationIcon = {}
            )
        },
        bottomBar = {},
    ) { innerPadding ->
        LazyColumn(modifier = Modifier.padding(innerPadding)) {
            item { PostCard(navigateToPostDetail) }
            item { PostCard(navigateToPostDetail) }
            item { PostCard(navigateToPostDetail) }
        }
    }

}