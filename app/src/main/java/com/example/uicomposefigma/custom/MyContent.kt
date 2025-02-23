package com.example.uicomposefigma.custom

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uicomposefigma.data.Topic
import com.example.uicomposefigma.ui.theme.UIComposeFigmaTheme

@Composable
fun MyContent(modifier: Modifier = Modifier) {
    // Danh sách chứa các topic được follow
    val followedTopics = remember { mutableStateListOf<Topic>() }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(start = 16.dp)
            .verticalScroll(rememberScrollState()) // Thêm khả năng kéo dọc
            .background(Color.Transparent) // Sử dụng màu trong suốt
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                "What are you interested in?",
                style = MaterialTheme.typography.titleMedium.copy(textAlign = TextAlign.Center),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                "Updates from interests you follow will appear here. Follow some things to get started.",
                style = MaterialTheme.typography.bodyMedium.copy(textAlign = TextAlign.Center)
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        ContactRow(contacts)


        Spacer(modifier = Modifier.height(16.dp))

        TopicsGrid(
            topics = topics,
            followedTopics = followedTopics,
            onFollowChanged = { topic, newFollowState ->
                if (newFollowState) {
                    // Nếu chuyển sang follow và danh sách chưa chứa topic này, thì thêm vào
                    if (!followedTopics.contains(topic)) followedTopics.add(topic)
                } else {
                    // Nếu chuyển sang unfollow thì loại bỏ topic đó khỏi danh sách
                    followedTopics.remove(topic)
                }
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { /* TODO: Handle Done */ },
            enabled = false,
            modifier = Modifier
                .width(380.dp)
                .height(40.dp)
        ) {
            Text("Done")
        }

        Spacer(modifier = Modifier.height(24.dp))


        Box(
            modifier = Modifier
                .width(380.dp)
                .height(25.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Browse topics",
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.labelSmall
            )
        }

        Spacer(modifier = Modifier.height(73.dp))

        // Hiển thị các Card dựa trên danh sách followedTopics
        followedTopics.forEach { topic ->
            CustomCard()
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_7, showSystemUi = true)
@Composable
private fun ContactRowPreview() {
    UIComposeFigmaTheme {
        MyContent()
    }
}