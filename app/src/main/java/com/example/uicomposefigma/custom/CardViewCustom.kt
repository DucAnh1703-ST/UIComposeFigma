package com.example.uicomposefigma.custom

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uicomposefigma.R
import com.example.uicomposefigma.ui.theme.UIComposeFigmaTheme

@Composable
fun CustomCard() {
    Card(
        modifier = Modifier
            .width(380.dp)
            .height(520.dp),
        shape = RoundedCornerShape(16.dp),
    ) {
        Column(
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
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(24.dp)
            ) {
                // Hình tròn với kích thước 24dp và màu nền
                Box(
                    modifier = Modifier
                        .size(24.dp) // Kích thước 24x24
                        .clip(CircleShape) // Cắt Box thành hình tròn
                        .background(Color.Blue) // Màu nền cho hình tròn
                )

                Text(text = "Author", modifier = Modifier.padding(start = 8.dp))

            }

            Spacer(modifier = Modifier.height(12.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(64.dp)
            ) {
                Text(text = "New Compose for Wear OS codelab")

            }

            Spacer(modifier = Modifier.height(12.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(16.dp)
            ) {
                Text(text = "New Compose for Wear OS codelab")
            }

            Spacer(modifier = Modifier.height(12.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(96.dp)
            ) {

            }

            Spacer(modifier = Modifier.height(12.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp)
            ) {

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