package com.realtime.realtimeblogs.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.realtime.realtimeblogs.R
import com.realtime.realtimeblogs.data.Repository
import com.realtime.realtimeblogs.ui.theme.RoundRectShape
import com.realtime.realtimeblogs.ui.components.InsetAwareTopAppBar
import com.realtime.realtimeblogs.ui.components.topAppBarIcon
import com.realtime.realtimeblogs.ui.components.topAppBarTitle

@Composable
fun PostDetailScreen(
    postsRepository: Repository,
    scaffoldState: ScaffoldState,
    postId: String?,
    onBack: () -> Unit
) {
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            InsetAwareTopAppBar(
                title = topAppBarTitle(title = "Post Detail"),
                navigationIcon = topAppBarIcon(onClickCallback = onBack)
            )
        },
        bottomBar = {}
    ) { innerPadding ->
        val scrollState = rememberScrollState()
        Column(
            modifier = Modifier
                .verticalScroll(state = scrollState)
                .fillMaxSize()
                .padding(innerPadding)
                .background(color = MaterialTheme.colors.background)
        ) {
            PostDetailHeaderSection()
            PostDetailContentHeaderSection()
            PostDetailContentSection()
        }
    }
}

@Composable
fun PostDetailHeaderSection() {
    Box {
        Surface(color = Color.Black.copy(alpha = 0.5f)) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
                    .clip(MaterialTheme.shapes.small),
                contentScale = ContentScale.FillBounds,
                alpha = 0.7f
            )
            Column(modifier = Modifier.align(Alignment.BottomCenter)) {
                Text(
                    text = "Khar said the development spoke volumes about",
                    style = MaterialTheme.typography.h5,
                    color = Color.White,
                    modifier = Modifier.padding(horizontal = 16.dp),
                    textAlign = TextAlign.Start
                )

                Text(
                    text = "Aug 02 . 1 min read",
                    style = MaterialTheme.typography.caption,
                    color = Color.White,
                    modifier = Modifier.padding(
                        start = 16.dp,
                        end = 16.dp,
                        top = 8.dp,
                        bottom = 16.dp
                    )
                )
            }
        }
    }
}

@Composable
fun PostDetailContentHeaderSection() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 16.dp)
    ) {

        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "Profile Image",
            modifier = Modifier
                .size(36.dp, 36.dp)
                .clip(RoundRectShape.small)
        )

        Column(
            modifier = Modifier
                .padding(horizontal = 8.dp)
        ) {
            Text(
                text = "Title",
                style = MaterialTheme.typography.subtitle2
            )
            Text(
                text = "Headline",
                style = MaterialTheme.typography.caption
            )
        }
    }
}

@Composable
fun PostDetailContentSection() {
    Text(
        modifier = Modifier
            .fillMaxHeight()
            .padding(vertical = 8.dp, horizontal = 16.dp),
        text = "A Composition describes the UI of your app and is produced by running composables. The Composition is a tree-structure that consists of the composables that describe your UI.\n" +
                "\n" +
                "Next to the Composition, there exists a parallel tree, called the Semantics tree. This tree describes your UI in an alternative manner that is understandable for Accessibility services and for the Testing framework. Accessibility services use the tree to describe the app to users with a specific need. The Testing framework uses it to interact with your app and make assertions about it. The Semantics tree does not contain the information on how to draw your composables, but it contains information about the semantic meaning of your composables." + "A Composition describes the UI of your app and is produced by running composables. The Composition is a tree-structure that consists of the composables that describe your UI.\n" +
                "\n" +
                "Next to the Composition, there exists a parallel tree, called the Semantics tree. This tree describes your UI in an alternative manner that is understandable for Accessibility services and for the Testing framework. Accessibility services use the tree to describe the app to users with a specific need. The Testing framework uses it to interact with your app and make assertions about it. The Semantics tree does not contain the information on how to draw your composables, but it contains information about the semantic meaning of your composables.",
        style = MaterialTheme.typography.body1
    )
}
