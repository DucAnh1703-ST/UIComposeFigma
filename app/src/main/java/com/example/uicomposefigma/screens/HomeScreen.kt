package com.example.uicomposefigma.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextDirection.Companion.Content
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.uicomposefigma.custom.MyContent
import com.example.uicomposefigma.custom.MyNavigationBar
import com.example.uicomposefigma.custom.MyTopBar
import com.example.uicomposefigma.ui.theme.UIComposeFigmaTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavHostController) {
    Scaffold(
        topBar = { MyTopBar() },
        content = { paddingValues ->
            MyContent(Modifier.padding(paddingValues))
        },
        bottomBar = { MyNavigationBar() }
    )
}

@Preview(showBackground = true, device = Devices.PIXEL_7, showSystemUi = true)
@Composable
private fun HomeScreenPreview() {
    UIComposeFigmaTheme {
        val navController = rememberNavController()
        HomeScreen(navController)
    }
}