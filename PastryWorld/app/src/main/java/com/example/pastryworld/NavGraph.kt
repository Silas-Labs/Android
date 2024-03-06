package com.example.pastryworld

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.pastryworld.composables.Dashboard
import com.example.pastryworld.composables.LoginScreen
import com.example.pastryworld.composables.SignUpScreen


@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "login") {

        composable(route = "login") {
            LoginScreen(navController)
        }
        composable(route = "signup") {
            SignUpScreen(navController)
        }
        composable(route = "dashboard") {
            Dashboard(navController)
        }
    }
}
