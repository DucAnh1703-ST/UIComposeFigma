package com.example.uicomposefigma.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
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
    // Tạo Brush.linearGradient với 2 màu và vị trí start, end
    val gradientBrush = Brush.linearGradient(
        colors = listOf(MaterialTheme.colorScheme.inverseOnSurface, MaterialTheme.colorScheme.primaryContainer),
        start = Offset(2000f, 0f),  // Vị trí bắt đầu
        end = Offset(0f, 3000f) // Vị trí kết thúc
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(gradientBrush)
    ) {
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
            bottomBar = { MyNavigationBar() },
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