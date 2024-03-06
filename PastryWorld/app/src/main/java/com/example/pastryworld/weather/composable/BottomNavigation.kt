package com.example.pastryworld.weather.composable

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Place
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomNav(navController: NavHostController) {
    data class NavItem(
        val icon: ImageVector,
        val name: String,
        val label: String
    )

    val navItems = listOf(
        NavItem(Icons.Rounded.Home, "home","Home"),
        NavItem(Icons.Rounded.Place, "locations","Locations"),
        NavItem(Icons.Rounded.Settings, "settings","Settings"),
    )
    val backStackEntry = navController.currentBackStackEntryAsState()

    NavigationBar(containerColor = Color.DarkGray) {
        navItems.forEach {
            val selected = it.name == backStackEntry.value?.destination?.route
            NavigationBarItem(
                selected = selected,
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.White,
                    unselectedIconColor = Color.Gray,
                    indicatorColor = Color(0xFFA18EFF)
                ),
                label = {
                    if(selected){
                        Text(text= it.label,
                            color = Color.Green)
                    }
                },
                onClick = { navController.navigate(it.name)
                },
                icon = {
                    Icon(imageVector = it.icon , contentDescription = it.name )
                })
        }
    }
}