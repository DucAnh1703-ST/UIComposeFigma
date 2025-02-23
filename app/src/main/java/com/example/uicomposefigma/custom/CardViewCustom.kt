package com.example.uicomposefigma.custom

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uicomposefigma.R
import com.example.uicomposefigma.ui.theme.UIComposeFigmaTheme

// Danh sách tiêu đề cho các button
val buttonLabels = listOf("Topic", "Compose", "Events", "Performance", "Topic1")

@Composable
fun CustomCard() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(500.dp),
//        contentAlignment = Alignment.Center
    ) {
        Card(
            modifier = Modifier
                .width(380.dp)
                .height(494.dp),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFFFFFFFF)
            ), // Đổi màu nền của Card
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(182.dp)
            ) {
                // Sử dụng Box để căn giữa ảnh
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color(0xff073042)), // Làm Box chiếm toàn bộ Column
                    contentAlignment = Alignment.Center, // Căn giữa nội dung trong Box
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_compose123), // Thay R.drawable.sample_image với hình ảnh của bạn
                        contentDescription = "Compose Image",
                        modifier = Modifier
                            .width(380.dp) // Chiều rộng của ảnh
                            .height(182.dp) // Chiều cao của ảnh
                    )
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)

            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(24.dp),
                    verticalAlignment = Alignment.CenterVertically // Căn giữa theo chiều dọc
                ) {
                    Box(
                        modifier = Modifier
                            .size(24.dp)
                            .clip(CircleShape)
                            .background(Color.Blue)
                    )

                    // Khoảng cách giữa hình tròn và chữ
                    Spacer(modifier = Modifier.width(8.dp))

                    Text(
                        text = "Author",
                        style = MaterialTheme.typography.labelSmall,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold
                    )
                }


                Spacer(modifier = Modifier.height(12.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(64.dp),
                ) {
                    Text(
                        text = "New Compose for Wear OS codelab",
                        modifier = Modifier
//                        .width(300.dp)
                            .weight(1f) // Đẩy button sang phải
                            .height(64.dp),
                        fontSize = (24.sp),
                        style = MaterialTheme.typography.headlineSmall,
                    )

                    Box(
                        modifier = Modifier
                            .size(40.dp)
                    ) {
                        Button(
                            onClick = { /* Xử lý khi nhấn */ },
                            shape = CircleShape,
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Magenta,
                                contentColor = Color.White
                            ),
                            modifier = Modifier.fillMaxSize() // Nút sẽ phủ toàn bộ Box
                        ) {}

                        Icon(
                            painter = painterResource(id = R.drawable.ic_icon), // XML drawable
                            contentDescription = "Bookmark",
                            modifier = Modifier
                                .align(Alignment.Center) // Căn giữa Icon
                                .size(18.dp),
                            tint = Color.Unspecified // Giữ nguyên màu gốc của icon
                        )
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Hình tròn bên trái
                    Box(
                        modifier = Modifier
                            .size(8.dp)
                            .clip(CircleShape)
                            .background(Color.Red) // Màu tuỳ chỉnh
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    // Ô thứ nhất
                    Box(
                        modifier = Modifier
                            .width(87.dp)
                            .fillMaxHeight(),    // Cao bằng Row
//                    contentAlignment = Alignment.Center // Căn giữa cả chiều ngang & dọc
                    ) {
                        Text(
                            text = "January 1, 2021",
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold,
                            style = MaterialTheme.typography.labelSmall.copy(textAlign = TextAlign.Center),
                            modifier = Modifier.fillMaxSize()
                        )
                    }

                    Spacer(modifier = Modifier.width(8.dp))

                    // Ô thứ nhất
                    Box(
                        modifier = Modifier
                            .width(124.dp)
                            .fillMaxHeight(),    // Cao bằng Row
                        contentAlignment = Alignment.Center // Căn giữa cả chiều ngang & dọc
                    ) {
                        Text(
                            text = "developer.android.com",
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold,
                            style = MaterialTheme.typography.labelSmall.copy(textAlign = TextAlign.Center),
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(96.dp)
                ) {
                    Text(
                        text = "In this codelab, you can learn how Wear " +
                                "OS can work with Compose, " +
                                "what Wear OS specific composables are available, and more!",
                        fontSize = 16.sp
                    )
                }

                Spacer(modifier = Modifier.height(12.dp))

                // Chỉ số nút đang được chọn
                var selectedIndex by remember { mutableIntStateOf(0) }

                Row(
                    modifier = Modifier
                        .width(348.dp)
                        .height(40.dp)
                ) {
                    // LazyRow cho phép cuộn ngang nếu có nhiều nút
                    LazyRow(
                        modifier = Modifier
                            .width(308.dp)
                            .height(32.dp),
                        // Khoảng cách ngang giữa các nút
                        horizontalArrangement = Arrangement.spacedBy(4.dp),
                    ) {
                        items(buttonLabels.size) { index ->
                            val label = buttonLabels[index]

                            // Xác định màu cho nút dựa trên trạng thái được chọn hay không
                            val containerColor = if (index == selectedIndex) {
                                // Màu khi nút được chọn (hồng đậm)
                                Color(0xFFFFD6F5)
                            } else {
                                // Màu khi nút chưa được chọn (hồng/ tím nhạt)
                                Color(0xFFF5E6F8)
                            }

                            Button(
                                onClick = {
                                    // Cập nhật nút được chọn
                                    selectedIndex = index
                                },
                                shape = RoundedCornerShape(50), // Bo tròn 2 đầu, tạo dạng pill
                                contentPadding = PaddingValues(horizontal = 12.dp, vertical = 8.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = containerColor, // Màu nền
                                    contentColor = Color.Black       // Màu chữ
                                ),
                                modifier = Modifier.height(32.dp)
                            ) {
                                Text(
                                    text = label,
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Bold,
                                    style = MaterialTheme.typography.labelSmall
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.width(8.dp))

                    Box(
                        modifier = Modifier
                            .size(32.dp)
                    ) {
                        Button(
                            onClick = { /* Xử lý khi nhấn */ },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.White,
                                contentColor = Color.White
                            ),
                            shape = RectangleShape, // Đặt hình dạng là hình chữ nhật
                            modifier = Modifier.fillMaxSize() // Nút sẽ phủ toàn bộ Box
                        ) {}

                        Icon(
                            painter = painterResource(id = R.drawable.ic_more_vert), // XML drawable
                            contentDescription = "More Vert",
                            modifier = Modifier
                                .align(Alignment.Center) // Căn giữa Icon
                                .size(18.dp),
                            tint = Color.Unspecified // Giữ nguyên màu gốc của icon
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_7, showSystemUi = true)
@Composable
private fun MyTopBarPreview() {
    UIComposeFigmaTheme {
        CustomCard()
    }
}