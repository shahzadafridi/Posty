package com.realtime.realtimeblogs.navigation.bottom

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.google.accompanist.insets.navigationBarsPadding
import com.realtime.realtimeblogs.navigation.MainDestinations

@Composable
fun BottomNavigationBar(
    navController: NavController
) {
    Card(
        modifier = Modifier
            .background(color = MaterialTheme.colors.background),
        elevation = 20.dp
    ) {
        BottomNavigation(
            backgroundColor = MaterialTheme.colors.background,
            contentColor = MaterialTheme.colors.primary,
            modifier = Modifier.navigationBarsPadding(),
            elevation = 0.dp
        ) {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route ?: MainDestinations.HOME_ROUTE

            BottomNavItem.items.forEach { bottomNavigationItem ->

                val colors = MaterialTheme.colors
                val imageAlpha = if (currentRoute == bottomNavigationItem.route) 1f
                else 0.6f
                val textIconColor = if (currentRoute == bottomNavigationItem.route) colors.primary
                else colors.onSurface.copy(alpha = 0.6f)
                val backgroundColor = if (currentRoute == bottomNavigationItem.route) colors.primary.copy(alpha = 0.12f)
                else Color.Transparent

                BottomNavigationItem(
                    icon = BottomNavigationItemIcon(
                        item = bottomNavigationItem,
                        textIconColor = textIconColor,
                        imageAlpha = imageAlpha
                    ),
                    label = BottomNavigationItemLabel(
                        item = bottomNavigationItem,
                        textIconColor = textIconColor
                    ),
                    selectedContentColor = MaterialTheme.colors.primary,
                    unselectedContentColor = MaterialTheme.colors.primary.copy(0.4f),
                    alwaysShowLabel = true,
                    selected = currentRoute == bottomNavigationItem.route,
                    onClick = onClick(navController,bottomNavigationItem)
                )
            }
        }
    }
}

fun onClick(
    navController: NavController,
    item: BottomNavItem
): () -> Unit {
    return {
        navController.navigate(item.route) {
            navController.graph.startDestinationRoute?.let { route ->
                // Pop up to the start destination of the graph to
                // avoid building up a large stack of destinations
                // on the back stack as users select items
                popUpTo(route){
                    saveState = true
                }
                // Avoid multiple copies of the same destination when
                // reselecting the same item
                launchSingleTop = true
                // Restore state when reselecting a previously selected item
                restoreState = true
            }
        }
    }
}

@Composable
fun BottomNavigationItemIcon(
    item: BottomNavItem,
    textIconColor: Color,
    imageAlpha: Float
): @Composable (() -> Unit) {
    return {
        Image(
            imageVector = item.icon,
            contentDescription = item.title,
            colorFilter = ColorFilter.tint(textIconColor),
            alpha = imageAlpha
        )
    }
}

@Composable
fun BottomNavigationItemLabel(
    item: BottomNavItem,
    textIconColor: Color
): @Composable (() -> Unit) {
    return {
        Text(
            text = item.title,
            style = MaterialTheme.typography.body2,
            color = textIconColor,
            modifier = Modifier.padding(4.dp)
        )
    }
}

