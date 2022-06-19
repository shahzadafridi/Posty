package com.realtime.realtimeblogs.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.realtime.realtimeblogs.data.FakeRepository
import com.realtime.realtimeblogs.data.Repository
import com.realtime.realtimeblogs.navigation.MainDestinations.POST_ID_KEY
import com.realtime.realtimeblogs.ui.screens.FavouriteTabScreen
import com.realtime.realtimeblogs.ui.screens.HomeTabScreen
import com.realtime.realtimeblogs.ui.screens.PostDetailScreen
import com.realtime.realtimeblogs.ui.screens.SettingTabScreen


@Composable
fun PostyNavGraph(
    scaffoldPadding: PaddingValues,
    repository: Repository,
    navController: NavHostController = rememberNavController(),
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    startDestination: String =  MainDestinations.HOME_ROUTE
){
    val actions = remember(navController) { MainActions(navController) }

    NavHost(
        navController = navController,
        startDestination = startDestination ){

        composable(MainDestinations.HOME_ROUTE) {
            HomeTabScreen(
                postsRepository = FakeRepository(),
                navigateToPostDetail = actions.navigateToPostDetail,
                scaffoldState = scaffoldState
            )
        }

        composable(MainDestinations.FAVORITE_ROUTE) {
            FavouriteTabScreen(
                postsRepository = FakeRepository(),
                navigateToPostDetail = actions.navigateToPostDetail,
                scaffoldState = scaffoldState,
                onBack = actions.upPress,
            )
        }

        composable(MainDestinations.SETTING_ROUTE) {
            SettingTabScreen(
                postsRepository = FakeRepository(),
                navigateToPostDetail = actions.navigateToPostDetail,
                scaffoldState = scaffoldState,
                onBack = actions.upPress,
            )
        }

        composable("${MainDestinations.POST_DETAIL_ROUTE}/{$POST_ID_KEY}") { backStackEntry ->
            PostDetailScreen(
                postId = backStackEntry.arguments?.getString(POST_ID_KEY),
                onBack = actions.upPress,
                postsRepository = FakeRepository(),
                scaffoldState = scaffoldState
            )
        }
    }
}

/**
 * Models the navigation actions in the app.
 */
class MainActions(navController: NavHostController) {
    val navigateToPostDetail: (String) -> Unit = { postId: String ->
        navController.navigate("${MainDestinations.POST_DETAIL_ROUTE}/$postId")
    }
    val upPress: () -> Unit = {
        navController.navigateUp()
    }
}

@Composable
public fun isNonBottomNavigationRoute(navController: NavHostController): Boolean {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route ?: ""
    return NonBottomNavigationRouteScreen.contains(currentRoute)
}