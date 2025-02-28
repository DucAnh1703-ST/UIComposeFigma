package com.example.uicomposefigma.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.uicomposefigma.screens.EpisodesScreen
import com.example.uicomposefigma.screens.HomeScreen
import com.example.uicomposefigma.screens.InterestsScreen
import com.example.uicomposefigma.screens.SavedScreen

@Composable
fun MyAppNavHost(navController: NavHostController) {
    NavHost(navController, startDestination = "home") {
        composable("home") {
            // Màn hình For You là màn hình mặc định, sẽ hiển thị HomeScreen
            HomeScreen(navController) // Đây là HomeScreen cho màn hình For You
        }
        composable("episodes") {
            // Màn hình Episodes
            EpisodesScreen(navController)
        }
        composable("saved") {
            // Màn hình Saved
            SavedScreen(navController)
        }
        composable("interests") {
            // Màn hình Interests
            InterestsScreen(navController)
        }
    }
}