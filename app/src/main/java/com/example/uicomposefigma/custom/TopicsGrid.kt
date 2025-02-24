package com.example.uicomposefigma.custom

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
fun TopicsGrid(
    topics: List<Topic>,
    followedTopics: List<Topic>,
    onFollowChanged: (Topic, Boolean) -> Unit
) {
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
            // Xác định trạng thái follow của topic dựa vào danh sách follow từ cha
            val isFollowed = followedTopics.contains(topic)
            Row(
                modifier = Modifier
                    .width(264.dp)
                    .height(56.dp)
                    .background(MaterialTheme.colorScheme.surface, RoundedCornerShape(8.dp)),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .padding(start = 12.dp) // Padding cho không gian bao quanh ảnh
                        .size(32.dp) // Kích thước ảnh cố định
                ) {
                    Image(
                        painter = painterResource(id = topic.image),
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize(), // Ảnh sẽ chiếm toàn bộ Box
                        colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.primary)
                    )
                }
                Spacer(modifier = Modifier.width(12.dp))
                Text(
                    text = topic.name,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurface,
                    fontSize = 14.sp
                )
                Spacer(modifier = Modifier.weight(1f))
                TinyToggleIcon(
                    isFollowed = isFollowed,
                    onClick = {
                        // Khi nhấn, chuyển trạng thái: nếu hiện tại đang follow thì unfollow, ngược lại follow
                        onFollowChanged(topic, !isFollowed)
                    },
                )
            }
        }
    }
}

@Composable
fun TinyToggleIcon(
    isFollowed: Boolean,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .size(24.dp)               // Kích thước vòng tròn 24.dp
            .clip(CircleShape)         // Cắt bo tròn
            .background(
                color = if (isFollowed) Color.Magenta else Color.Transparent
            )
            .clickable { onClick() }   // Xử lý nhấn
    ) {
        Icon(
            painter = painterResource(
                id = if (isFollowed) R.drawable.ic_icon_true else R.drawable.ic_add
            ),
            contentDescription = null,
            tint = Color.Black,
            modifier = Modifier
                .size(18.dp)
                .align(Alignment.Center) // Căn icon vào giữa
        )
    }

    Spacer(modifier = Modifier.width(9.dp)) // Tạo khoảng cách 9dp
}

//@Preview(showBackground = true, device = Devices.PIXEL_7, showSystemUi = true)
//@Composable
//private fun TopicsGridPreview() {
//    UIComposeFigmaTheme {
//        TopicsGrid(topics)
//    }
//}