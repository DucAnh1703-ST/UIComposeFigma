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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uicomposefigma.R
import com.example.uicomposefigma.ui.theme.UIComposeFigmaTheme

// Danh sách tiêu đề cho các button
val buttonLabels = listOf("Topic", "Compose", "Events", "Performance")

@Composable
fun CustomCard() {
    Card(
        modifier = Modifier
            .width(380.dp)
            .height(494.dp),
        shape = RoundedCornerShape(16.dp),
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

                Text(text = "Author")
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
                        .width(300.dp)
                        .height(64.dp), fontSize = (23.sp)
                )

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
                        textAlign = TextAlign.Center,      // Căn giữa chữ trong Box
                        modifier = Modifier.fillMaxWidth(), // Để text chiếm hết bề rộng Box
                        fontSize = 10.sp
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
                        textAlign = TextAlign.Center,      // Căn giữa chữ trong Box
                        modifier = Modifier.fillMaxWidth(), // Để text chiếm hết bề rộng Box
                        fontSize = 10.sp
                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(96.dp)
            ) {
                Text(text = "In this codelab, you can learn how Wear " +
                        "OS can work with Compose, " +
                        "what Wear OS specific composables are available, and more!")
            }

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp)
            ) {
                LazyRow(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
                ) {
                    items(buttonLabels.size) { index ->
                        val label = buttonLabels[index]
                        Button(
                            onClick = { /* handle click */ },
                            shape = RoundedCornerShape(50), // Bo 2 đầu, tạo dạng pill
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFFE0E0E0), // Màu nền
                                contentColor = Color.Black            // Màu nội dung
                            ),
                            modifier = Modifier.height(40.dp) // Chiều cao tùy chỉnh
                        ) {
                            Text(text = label)
                        }
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