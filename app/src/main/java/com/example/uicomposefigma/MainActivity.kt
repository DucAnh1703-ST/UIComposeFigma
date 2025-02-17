package com.example.uicomposefigma

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.example.uicomposefigma.navigation.MyAppNavHost
import com.example.uicomposefigma.ui.theme.UIComposeFigmaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UIComposeFigmaTheme{
                val navController = rememberNavController()
                MyAppNavHost(navController)
            }
        }
    }
}