package com.example.samplecompose.ui.home

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

import androidx.compose.runtime.*
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.tooling.preview.Preview


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreen(viewModel: HomeViewModel = hiltViewModel()) {
    val isConnected by viewModel.isNetworkAvailable.collectAsState(initial = true)

    if (isConnected) {
        Text("✅ You are online")
    } else {
        Text("❌ No internet connection")
    }
}

