package com.example.uicomposefigma.custom

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uicomposefigma.ui.theme.UIComposeFigmaTheme

@Composable
fun MyContent(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(start = 16.dp)
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

        TopicsGrid(topics)


        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { /* TODO: Handle Done */ },
            enabled = false,
            modifier = Modifier.width(380.dp).height(40.dp)
        ) {
            Text("Done")
        }

//        Spacer(modifier = Modifier.height(24.dp))
//
//        Text(
//            text = "Browse topics"
//        )
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_7, showSystemUi = true)
@Composable
private fun ContactRowPreview() {
    UIComposeFigmaTheme {
        MyContent()
    }
}