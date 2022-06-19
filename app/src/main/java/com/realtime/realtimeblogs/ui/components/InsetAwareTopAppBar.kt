package com.realtime.realtimeblogs.ui.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.google.accompanist.insets.navigationBarsPadding
import org.w3c.dom.Text

/**
 * A wrapper around [TopAppBar] which uses [Modifier.statusBarsPadding] to shift the app bar's
 * contents down, but still draws the background behind the status bar too.
 */
@Composable
fun InsetAwareTopAppBar(
    title: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    navigationIcon: @Composable (() -> Unit)? = null,
    actions: @Composable RowScope.() -> Unit = {},
    backgroundColor: Color = MaterialTheme.colors.primarySurface,
    contentColor: Color = contentColorFor(backgroundColor),
    elevation: Dp = 4.dp
) {
    Surface(
        color = backgroundColor,
        elevation = elevation,
        modifier = modifier
    ) {
        TopAppBar(
            title = title,
            navigationIcon = navigationIcon,
            actions = actions,
            backgroundColor = Color.Transparent,
            contentColor = contentColor,
            elevation = 0.dp,
            modifier = modifier
                .navigationBarsPadding(bottom = false)
                .statusBarsPadding(),
         )
    }
}

@Composable
fun topAppBarTitle(title: String): @Composable (() -> Unit) {
    return {
        Text(
            text = title,
            style = MaterialTheme.typography.subtitle1,
            color = LocalContentColor.current
        )
    }
}

@Composable
fun topAppBarIcon(
    icon: ImageVector = Icons.Filled.ArrowBack,
    desc: String? = "",
    onClickCallback: () -> Unit
): @Composable (() -> Unit) {
    return {
        IconButton(onClick = onClickCallback) {
            Icon(
                imageVector = icon,
                contentDescription = desc
            )
        }
    }
}
