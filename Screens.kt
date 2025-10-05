package com.nextalk.app

import androidx.compose.runtime.Composable
import androidx.compose.material3.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.layout.height
import androidx.compose.ui.unit.dp
import androidx.compose.ui.layout.ContentScale

@Composable
fun HomeScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        Image(painter = painterResource(R.drawable.nexlogo), contentDescription = null, modifier = androidx.compose.ui.Modifier
            .height(180.dp), contentScale = ContentScale.Fit)
        Text("Welcome to Nextalk — your adventurous platform!")
    }
}

@Composable
fun ChatScreen() {
    val messages = listOf("Hello!", "How are you?", "Welcome to Nextalk chat sample")
    LazyColumn {
        items(messages) { msg ->
            Card(modifier = Modifier.padding(8.dp)) {
                Text(msg, modifier = Modifier.padding(12.dp))
            }
        }
    }
}

@Composable
fun VideoListScreen(navController: NavController) {
    val sampleVideos = listOf(
        Pair("Sample Video 1", "https://storage.googleapis.com/exoplayer-test-media-0/BigBuckBunny_320x180.mp4"),
        Pair("Sample Video 2", "https://storage.googleapis.com/exoplayer-test-media-0/BigBuckBunny_320x180.mp4")
    )

    LazyColumn {
        items(sampleVideos) { video ->
            Card(modifier = Modifier
                .padding(8.dp)
            ) {
                Column(modifier = Modifier.padding(12.dp)) {
                    Text(video.first)
                    Text("Tap to play - not wired in this minimal build")
                }
            }
        }
    }
}

data class Product(val name: String, val description: String, val price: Double)

@Composable
fun ShopScreen() {
    val products = listOf(
        Product("Backpack", "Durable adventure backpack", 29.99),
        Product("Water Bottle", "Insulated 1L bottle", 12.5),
        Product("Headlamp", "LED headlamp with adjustable brightness", 8.99)
    )
    LazyColumn {
        items(products) { p ->
            Card(modifier = Modifier.padding(8.dp)) {
                Column(modifier = Modifier.padding(12.dp)) {
                    Text(p.name)
                    Text(p.description)
                    Text("$${p.price}")
                    Button(onClick = { /* TODO: go to checkout or open Stripe */ }) {
                        Text("Buy")
                    }
                }
            }
        }
    }
}

@Composable
fun AIChatScreen() {
    val inputState = remember { mutableStateOf("") }
    val messages = remember { mutableStateOf(mutableListOf("AI: Hi! I'm Nextalk AI (sample). Ask me something.")) }

    Column {
        LazyColumn(modifier = androidx.compose.ui.Modifier.weight(1f)) {
            items(messages.value) { msg ->
                Card(modifier = Modifier.padding(8.dp)) { Text(msg, modifier = Modifier.padding(12.dp)) }
            }
        }
        OutlinedTextField(value = inputState.value, onValueChange = { inputState.value = it }, placeholder = { Text("Ask AI...") })
        Button(onClick = {
            if (inputState.value.isNotBlank()) {
                messages.value.add("You: ${inputState.value}")
                messages.value.add("AI: (sample reply) I heard: ${inputState.value}")
                inputState.value = ""
            }
        }) {
            Text("Send to AI")
        }
    }
}
