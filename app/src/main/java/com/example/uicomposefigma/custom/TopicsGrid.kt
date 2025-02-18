package com.example.uicomposefigma.custom

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uicomposefigma.R
import com.example.uicomposefigma.data.Topic
import com.example.uicomposefigma.ui.theme.UIComposeFigmaTheme

val topics = listOf(
    Topic(R.drawable.ic_accessibility, "Accessibility"),
    Topic(R.drawable.ic_android_tv, "Android Auto"),
    Topic(R.drawable.ic_android_studio, "Android Studio"),
    Topic(R.drawable.ic_android_tv, "Android TV"),
    Topic(R.drawable.ic_architecture, "Architecture"),
    Topic(R.drawable.ic_compose, "Compose")
)

@Composable
fun TopicsGrid(topics: List<Topic>) {
    LazyHorizontalGrid(
        rows = GridCells.Fixed(3), // Hiển thị 2 cột
        modifier = Modifier
            .height(200.dp)
            .width(536.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp), // Khoảng cách giữa các dòng
        horizontalArrangement = Arrangement.spacedBy(8.dp) // Khoảng cách giữa các cột
    ) {
        items(topics.size) { index ->
            val topic = topics[index]
            Row(
                modifier = Modifier
                    .width(264.dp)
                    .height(56.dp)
                    .background(MaterialTheme.colorScheme.surface, RoundedCornerShape(8.dp)),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = topic.image),
                    contentDescription = null,
                    modifier = Modifier.size(32.dp),
                    colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.primary)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = topic.name, style = MaterialTheme.typography.bodyMedium)
                Spacer(modifier = Modifier.weight(1f))
                IconButton(onClick = { /* TODO: Follow topic */ }) {
                    Icon(Icons.Default.Add, contentDescription = "Follow", modifier = Modifier.size(18.dp))
                }
            }
        }
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_7, showSystemUi = true)
@Composable
private fun TopicsGridPreview() {
    UIComposeFigmaTheme {
        TopicsGrid(topics)
    }
}