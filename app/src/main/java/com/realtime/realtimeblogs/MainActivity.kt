package com.realtime.realtimeblogs

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.core.view.WindowCompat
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.realtime.realtimeblogs.data.FakeRepository
import com.realtime.realtimeblogs.navigation.PostyNavGraph
import com.realtime.realtimeblogs.ui.theme.PostyTheme
import com.realtime.realtimeblogs.ui.components.InsetAwareTopAppBar
import com.realtime.realtimeblogs.ui.components.topAppBarTitle
import com.realtime.realtimeblogs.ui.items.PostCard
import com.realtime.realtimeblogs.ui.screens.PostyApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
          PostyApp()
        }
    }

    @OptIn(ExperimentalUnitApi::class)
    @Composable
    fun DefaultPreview(innerPadding: PaddingValues) {
        PostyTheme {

        }
    }
}


