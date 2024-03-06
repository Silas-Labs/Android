package com.skill.labs.weatherapp.composables


import android.content.SharedPreferences
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun Navigation(
    navController: NavHostController
)
{
    NavHost(navController = navController, startDestination = "locations") {
        composable(route = "home") {
            Weather()
        }
        composable(route = "locations") {
            Locations()
        }
        composable(route = "settings") {
            Settings()
        }
    }
}