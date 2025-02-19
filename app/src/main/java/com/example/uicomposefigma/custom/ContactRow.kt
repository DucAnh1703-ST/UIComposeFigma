package com.example.uicomposefigma.custom

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
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
import com.example.uicomposefigma.data.Contact
import com.example.uicomposefigma.ui.theme.UIComposeFigmaTheme

val contacts = listOf(
    Contact(R.drawable.ic_launcher_background, "Fernando"),
    Contact(R.drawable.ic_launcher_background, "Alex"),
    Contact(R.drawable.ic_launcher_background, "Sam"),
    Contact(R.drawable.ic_launcher_background, "Lee"),
    Contact(R.drawable.ic_launcher_background, "Lee1"),
    Contact(R.drawable.ic_launcher_background, "Lee2"),
    Contact(R.drawable.ic_launcher_background, "Lee3")
)

@Composable
fun ContactRow(contacts: List<Contact>) {
    LazyRow(
        modifier = Modifier
            .width(412.dp)
            .height(72.dp).padding( start = 0.dp)
    ) {
        items(contacts.size) { index ->
            val contact = contacts[index]
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(start = 24.dp)
                    .width(64.dp)
                    .height(72.dp)
            ) {
                Box(
                    modifier = Modifier
                        .width(52.dp)
                        .height(48.dp)
                        .padding(2.dp)
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.surfaceVariant)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_avatar),
                        contentDescription = "Avatar",
                        modifier = Modifier
                            .size(24.dp)
                            .align(Alignment.Center)
                    )

                    Box(
                        modifier = Modifier
                            .size(24.dp)
                            .clip(CircleShape)
                            .background(Color.White)
                            .align(Alignment.BottomEnd)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = "Add",
//                            modifier = Modifier.size(12.dp)
                        )
                    }


                }
                Text(text = contact.name, style = MaterialTheme.typography.bodyMedium)
            }
        }
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_7, showSystemUi = true)
@Composable
private fun ContactRowPreview() {
    UIComposeFigmaTheme {
        ContactRow(contacts)
    }
}