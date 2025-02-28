package com.example.uicomposefigma.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.uicomposefigma.custom.CustomBackground
import com.example.uicomposefigma.custom.MyNavigationBar

@Composable
fun EpisodesScreen(navController: NavHostController) {
    CustomBackground {
        Scaffold(
            containerColor = Color.Transparent,
            content = { paddingValues ->
                Box(
                    modifier = Modifier
                        .fillMaxSize()  // Đảm bảo Box chiếm toàn bộ màn hình
                        .padding(paddingValues),  // Đảm bảo nội dung không bị cắt
                    contentAlignment = Alignment.Center  // Căn giữa nội dung trong Box
                ) {
                    Text(text = "Episodes Screen", fontWeight = FontWeight.Bold, fontSize = 20.sp)
                }
            },
            bottomBar = { MyNavigationBar(navController) }, // Hiển thị thanh điều hướng
        )
    }
}
