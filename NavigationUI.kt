package com.nextalk.app

import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Chat
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.BubbleChart
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.compose.material3.Icon
import androidx.compose.material3.Text

@Composable
fun NextalkBottomBar(navController: NavHostController) {
    NavigationBar {
        NavigationBarItem(selected = false, onClick = { navController.navigate("home") }, icon = { Icon(Icons.Default.Home, contentDescription="Home") }, label = { Text("Home") })
        NavigationBarItem(selected = false, onClick = { navController.navigate("chat") }, icon = { Icon(Icons.Default.Chat, contentDescription="Chat") }, label = { Text("Chat") })
        NavigationBarItem(selected = false, onClick = { navController.navigate("videos") }, icon = { Icon(Icons.Default.PlayArrow, contentDescription="Videos") }, label = { Text("Videos") })
        NavigationBarItem(selected = false, onClick = { navController.navigate("shop") }, icon = { Icon(Icons.Default.ShoppingCart, contentDescription="Shop") }, label = { Text("Shop") })
        NavigationBarItem(selected = false, onClick = { navController.navigate("ai") }, icon = { Icon(Icons.Default.BubbleChart, contentDescription="AI") }, label = { Text("AI") })
    }
}
