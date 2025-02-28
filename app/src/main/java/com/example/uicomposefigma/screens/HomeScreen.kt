package com.example.uicomposefigma.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.uicomposefigma.custom.CustomBackground
import com.example.uicomposefigma.custom.MyContent
import com.example.uicomposefigma.custom.MyNavigationBar
import com.example.uicomposefigma.custom.MyTopBar
import com.example.uicomposefigma.ui.theme.UIComposeFigmaTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavHostController) {
    CustomBackground {
        Scaffold(
            containerColor = Color.Transparent, // Đảm bảo Scaffold không vẽ nền riêng
            topBar = { MyTopBar() },
            content = { paddingValues ->
                MyContent(
                    Modifier
                        .padding(paddingValues)
                        .fillMaxSize()
                )
            },
            bottomBar = { MyNavigationBar(navController) },
        )
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_7, showSystemUi = true)
@Composable
private fun HomeScreenPreview() {
    UIComposeFigmaTheme {
        val navController = rememberNavController()
        HomeScreen(navController)
    }
}