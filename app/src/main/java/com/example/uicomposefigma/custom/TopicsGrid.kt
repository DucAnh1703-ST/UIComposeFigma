package com.example.uicomposefigma.custom

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uicomposefigma.R
import com.example.uicomposefigma.data.Topic
import com.example.uicomposefigma.ui.theme.UIComposeFigmaTheme

val topics = listOf(
    Topic(R.drawable.ic_launcher_background, "Accessibility"),
    Topic(R.drawable.ic_launcher_background, "Android Auto"),
    Topic(R.drawable.ic_launcher_background, "Android Studio"),
    Topic(R.drawable.ic_launcher_background, "Architecture"),
    Topic(R.drawable.ic_launcher_background, "Android TV"),
    Topic(R.drawable.ic_launcher_background, "Compose")
)

@Composable
fun TopicsGrid(topics: List<Topic>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2), // Hiển thị 2 cột
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(8.dp)
    ) {
        items(topics.size) { index ->
            val topic = topics[index]
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .background(MaterialTheme.colorScheme.surface, RoundedCornerShape(8.dp))
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = topic.image),
                    contentDescription = null,
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = topic.name, style = MaterialTheme.typography.bodyMedium)
                Spacer(modifier = Modifier.weight(1f))
                IconButton(onClick = { /* TODO: Follow topic */ }) {
                    Icon(Icons.Default.Add, contentDescription = "Follow")
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