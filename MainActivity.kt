package com.nextalk.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.nextalk.app.ui.theme.NextalkTheme
import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.size
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.TopAppBar
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NextalkTheme {
                AppEntryPoint()
            }
        }
    }
}

@Composable
fun AppEntryPoint() {
    val navController = rememberNavController()

    Scaffold(
        topBar = { NextalkTopBar() },
        bottomBar = { NextalkBottomBar(navController) }
    ) { padding ->
        NavHost(navController = navController, startDestination = "home") {
            composable("home") { HomeScreen() }
            composable("chat") { ChatScreen() }
            composable("videos") { VideoListScreen(navController) }
            composable("shop") { ShopScreen() }
            composable("ai") { AIChatScreen() }
        }
    }
}

@Composable
fun NextalkTopBar() {
    TopAppBar(
        title = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(painter = painterResource(id = R.drawable.nexlogo), contentDescription = "Nextalk logo", modifier = Modifier.size(36.dp))
                androidx.compose.material3.Text("Nextalk", modifier = Modifier.padding(start = 8.dp))
            }
        },
        modifier = Modifier.fillMaxWidth()
    )
}
