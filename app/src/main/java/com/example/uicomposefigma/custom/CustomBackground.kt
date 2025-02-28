package com.example.uicomposefigma.custom

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush

@Composable
fun CustomBackground(content: @Composable () -> Unit) {
    // Tạo Brush.linearGradient với 2 màu và vị trí start, end
    val gradientBrush = Brush.linearGradient(
        colors = listOf(
            MaterialTheme.colorScheme.inverseOnSurface,
            MaterialTheme.colorScheme.primaryContainer
        ),
        start = Offset(2000f, 0f),  // Vị trí bắt đầu
        end = Offset(0f, 3000f)     // Vị trí kết thúc
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(gradientBrush)
    ) {
        content()  // Hiển thị các nội dung màn hình bên trong
    }
}
