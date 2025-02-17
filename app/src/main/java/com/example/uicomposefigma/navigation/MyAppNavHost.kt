package com.example.uicomposefigma.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.uicomposefigma.screens.DetailsScreen
import com.example.uicomposefigma.screens.HomeScreen

@Composable
fun MyAppNavHost(navController: NavHostController) {
    NavHost(navController, startDestination = "home") {
        composable("home") { HomeScreen(navController) }
//        composable("details") { DetailsScreen(navController) }
//        // Thêm các destination khác tại đây
    }
}