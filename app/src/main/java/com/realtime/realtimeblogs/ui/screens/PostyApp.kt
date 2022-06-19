package com.realtime.realtimeblogs.ui.screens

import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.realtime.realtimeblogs.data.FakeRepository
import com.realtime.realtimeblogs.navigation.PostyNavGraph
import com.realtime.realtimeblogs.ui.theme.PostyTheme

@Composable
fun PostyApp() {
    PostyTheme {
        ProvideWindowInsets {
            val systemUiController = rememberSystemUiController()
            SideEffect {
                systemUiController.setSystemBarsColor(Color.Transparent, darkIcons = false)
            }

            val navController = rememberNavController()
            val scaffoldState = rememberScaffoldState()

            Scaffold(
                scaffoldState = scaffoldState,
                bottomBar = {}
            ) {
                PostyNavGraph(
                    scaffoldPadding = it,
                    repository = FakeRepository(),
                    navController = navController,
                    scaffoldState = scaffoldState
                )
            }
        }
    }
}