package com.example.uicomposefigma.custom

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uicomposefigma.R
import com.example.uicomposefigma.ui.theme.UIComposeFigmaTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopBar() {
    TopAppBar(
        modifier = Modifier
            .fillMaxWidth(),
        title = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                contentAlignment = Alignment.Center,

                ) {
                Text(
                    text = "Now in Android",
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface,
                    fontSize = 22.sp,
                    style = MaterialTheme.typography.titleLarge,
                )
            }
        },
        navigationIcon = {
            Image(
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = "Search",
                modifier = Modifier
                    .clickable(true) {
                        { /* Handle navigation icon click */ }
                    }
                    .padding(start = 16.dp)
            )
        },
        actions = {
            Image(
                painter = painterResource(id = R.drawable.ic_account),
                contentDescription = "Account",
                modifier = Modifier
                    .clickable(true) {
                        { /* Handle navigation icon click */ }
                    }
                    .padding(end = 16.dp)
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
//            containerColor = Color(0xFFFDEDF9)  // Đặt màu nền cho TopAppBar
            containerColor = Color.Transparent
        )
    )
}

@Preview(showBackground = true, device = Devices.PIXEL_7, showSystemUi = true)
@Composable
private fun MyTopBarPreview() {
    UIComposeFigmaTheme {
        MyTopBar()
    }
}