package com.example.uicomposefigma.custom

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.uicomposefigma.R
import com.example.uicomposefigma.data.NavBarItem
import com.example.uicomposefigma.ui.theme.UIComposeFigmaTheme

@Composable
fun MyNavigationBar() {
    var selectedIndex by remember { mutableIntStateOf(0) } // Quản lý index của item đang được chọn

    val navigation = listOf(
        NavBarItem(R.drawable.ic_upcoming_border, R.drawable.ic_icon_upcoming, "For you"),
        NavBarItem(R.drawable.ic_menu_book_border, R.drawable.ic_menu_book, "Episodes"),
        NavBarItem(R.drawable.ic_bookmarks_border, R.drawable.ic_bookmarks, "Saved"),
        NavBarItem(R.drawable.ic_tag, R.drawable.ic_tag, "Interests")
    )

    NavigationBar(
        modifier = Modifier.background(MaterialTheme.colorScheme.background)
    ) {
        navigation.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = selectedIndex == index, // Kiểm tra xem item này có được chọn không
                onClick = { selectedIndex = index }, // Cập nhật index khi người dùng click vào item
                icon = {
                    Icon(
                        painter = painterResource(id = if (selectedIndex == index) item.iconSelected else item.icon),
                        contentDescription = item.title,
                        tint = getIconColor() // Set màu theo chế độ sáng/tối
                    )
                },
                label = {
                    Text(
                        text = item.title,
                        color = MaterialTheme.colorScheme.onSurface,
                        style = MaterialTheme.typography.labelMedium,
                        fontSize = 12.sp
                    )
                },
                colors = NavigationBarItemColors(
                    selectedIconColor = Color.Unspecified,
                    selectedTextColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    selectedIndicatorColor = MaterialTheme.colorScheme.primaryContainer,
                    unselectedIconColor = Color.Unspecified,
                    unselectedTextColor = Color.Unspecified,
                    disabledIconColor = Color.Unspecified,
                    disabledTextColor = Color.Unspecified
                )
            )
        }
    }
}

@Composable
fun getIconColor(): Color {
    return if (isSystemInDarkTheme()) {
        MaterialTheme.colorScheme.onSurfaceVariant // Màu icon khi ở Dark Mode
    } else {
        MaterialTheme.colorScheme.onSurface // Màu icon khi ở Light Mode
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_7, showSystemUi = true)
@Composable
private fun MyNavigationBarPreview() {
    UIComposeFigmaTheme {
        MyNavigationBar()
    }
}