package com.realtime.realtimeblogs.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.realtime.realtimeblogs.data.FakeRepository
import com.realtime.realtimeblogs.data.Repository
import com.realtime.realtimeblogs.navigation.MainDestinations.POST_ID_KEY
import com.realtime.realtimeblogs.ui.screens.HomeTabScreen
import com.realtime.realtimeblogs.ui.screens.PostDetailScreen


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