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
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.uicomposefigma.R
import com.example.uicomposefigma.data.NavBarItem
import com.example.uicomposefigma.ui.theme.UIComposeFigmaTheme

@Composable
fun MyNavigationBar(navController: NavHostController) {
    // Lấy route hiện tại từ NavController
    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route

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
            // Cập nhật trạng thái selectedIndex dựa trên route hiện tại
            val isSelected = currentRoute == when (index) {
                0 -> "home" // Màn hình "For you"
                1 -> "episodes" // Màn hình "Episodes"
                2 -> "saved" // Màn hình "Saved"
                3 -> "interests" // Màn hình "Interests"
                else -> ""
            }

            NavigationBarItem(
                selected = isSelected, // Kiểm tra xem route hiện tại có phải màn hình này không
                onClick = {
                    // Điều hướng đến màn hình tương ứng khi click vào item
                    when (index) {
                        0 -> navController.navigate("home")
                        1 -> navController.navigate("episodes")
                        2 -> navController.navigate("saved")
                        3 -> navController.navigate("interests")
                    }
                },
                icon = {
                    Icon(
                        painter = painterResource(id = if (isSelected) item.iconSelected else item.icon),
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

//@Preview(showBackground = true, device = Devices.PIXEL_7, showSystemUi = true)
//@Composable
//private fun MyNavigationBarPreview() {
//    UIComposeFigmaTheme {
//        MyNavigationBar()
//    }
//}