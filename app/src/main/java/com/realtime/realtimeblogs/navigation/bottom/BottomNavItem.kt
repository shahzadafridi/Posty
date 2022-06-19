package com.realtime.realtimeblogs.navigation.bottom

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.SettingsPhone
import androidx.compose.ui.graphics.vector.ImageVector
import com.realtime.realtimeblogs.navigation.MainDestinations

sealed class BottomNavItem(var route: String, var icon: ImageVector, var title: String){
    companion object{
        val items = listOf(Home, Favorite, Setting)
    }
    object Home : BottomNavItem(MainDestinations.HOME_ROUTE, Icons.Filled.Home, "HOME")
    object Favorite : BottomNavItem(MainDestinations.FAVORITE_ROUTE, Icons.Filled.FavoriteBorder, "Favorite")
    object Setting : BottomNavItem(MainDestinations.SETTING_ROUTE, Icons.Filled.SettingsPhone, "Setting")
}
